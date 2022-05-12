/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Categoriet;
import entite.Transport;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import util.MyDB;

/**
 *
 * @author DELL
 */
public class TransportService /*implements iservice<Transport>*/ {

    Connection cnx;

    public TransportService() {
        cnx = MyDB.getInstance().getConnection();
    }

    public void ajouterTransport(Transport e) throws SQLException {
        String req = "INSERT INTO `transport` (`categorie_t_id`,`lieu_depart`,`lieu_arrivee`,`date_dep`,`date_arrivee`,`heure_arrivee`,`heure_depart`,`date_retour`,`heure_retour`,`nb_place`,`nb_bagage`,`prix_t`,`disponibilite`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, e.getId_cat());
        ps.setString(2, e.getLieu_depart());
        ps.setString(3, e.getLieu_arrivee());
        ps.setDate(4, (java.sql.Date) (Date) e.getDate_dep());
        ps.setDate(5, (java.sql.Date) (Date) e.getDate_arrivee());
        ps.setString(6, e.getHeure_arrivee());
        ps.setString(7, e.getHeure_depart());
        ps.setDate(8, (java.sql.Date) (Date) e.getDate_retour());
        ps.setString(9, e.getHeure_retour());
        ps.setInt(10, e.getNb_place());
        ps.setInt(11, e.getNb_bagage());
        ps.setInt(12, e.getPrix_t());
        ps.setInt(13, e.getDisp());

        ps.executeUpdate();
    }

    public List<Transport> AfficherAllTransport() throws SQLException {

        List<Transport> Transports = new ArrayList<>();
        String req = "select * from transport ";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Transport e = new Transport(rst.getInt("id"),
                     rst.getInt("categorie_t_id"),
                     rst.getString("lieu_depart"),
                     rst.getString("lieu_arrivee"),
                     rst.getDate("date_dep"),
                     rst.getDate("date_arrivee"),
                     rst.getString("heure_arrivee"),
                     rst.getString("heure_depart"),
                     rst.getDate("date_retour"),
                     rst.getString("heure_retour"),
                     rst.getInt("nb_place"),
                     rst.getInt("nb_bagage"),
                     rst.getInt("prix_t"),
                     rst.getInt("disponibilite"));
            Transports.add(e);
        }
        return Transports;
    }

    public List<Transport> AfficherAllTransportBydate() throws SQLException {

        List<Transport> Transports = new ArrayList<>();
        String req = "select * from transport order by date_dep  ";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Transport e = new Transport(rst.getInt("id"),
                     rst.getInt("categorie_t_id"),
                     rst.getString("lieu_depart"),
                     rst.getString("lieu_arrivee"),
                     rst.getDate("date_dep"),
                     rst.getDate("date_arrivee"),
                     rst.getString("heure_arrivee"),
                     rst.getString("heure_depart"),
                     rst.getDate("date_retour"),
                     rst.getString("heure_retour"),
                     rst.getInt("nb_place"),
                     rst.getInt("nb_bagage"),
                     rst.getInt("prix_t"),
                     rst.getInt("disponibilite"));
            Transports.add(e);
        }
        return Transports;
    }

    public List<Transport> AfficherAllTransportByLiey() throws SQLException {

        List<Transport> Transports = new ArrayList<>();
        String req = "select * from transport order by lieu_depart  ";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Transport e = new Transport(rst.getInt("id"),
                     rst.getInt("categorie_t_id"),
                     rst.getString("lieu_depart"),
                     rst.getString("lieu_arrivee"),
                     rst.getDate("date_dep"),
                     rst.getDate("date_arrivee"),
                     rst.getString("heure_arrivee"),
                     rst.getString("heure_depart"),
                     rst.getDate("date_retour"),
                     rst.getString("heure_retour"),
                     rst.getInt("nb_place"),
                     rst.getInt("nb_bagage"),
                     rst.getInt("prix_t"),
                     rst.getInt("disponibilite"));
            Transports.add(e);
        }
        return Transports;
    }

    public void SupprimerTransport(Transport e) throws SQLException {

        String req = "DELETE FROM transport WHERE id =?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, e.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public void modifierTransport(Transport e) throws SQLException, NoSuchAlgorithmException {
        String req = "UPDATE transport SET "
                + " categorie_t_id='" + e.getId_cat() + "'"
                + ", lieu_depart='" + e.getLieu_depart() + "'"
                + ", lieu_arrivee='" + e.getLieu_arrivee() + "'"
                + ", date_dep='" + (java.sql.Date) (Date) e.getDate_dep() + "'"
                + ", date_arrivee='" + (java.sql.Date) (Date) e.getDate_arrivee() + "'"
                + ", heure_arrivee='" + e.getHeure_arrivee() + "'"
                + ", heure_depart='" + e.getHeure_depart() + "'"
                + ", date_retour='" + (java.sql.Date) (Date) e.getDate_retour() + "'"
                + ", heure_retour='" + e.getHeure_retour() + "'"
                + ", nb_place='" + e.getNb_place() + "'"
                + ", nb_bagage='" + e.getNb_bagage() + "'"
                + ", prix_t='" + e.getPrix_t() + "'"
                + ", disponibilite='" + e.getDisp() + "' where id  = " + e.getId() + "";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(req);
    }
     
    public Transport GetById(int id) throws SQLException {
        return AfficherAllTransport().stream().filter(e -> e.getId()== id).findFirst().get();
    }

}
