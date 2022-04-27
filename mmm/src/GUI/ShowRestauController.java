/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Restaurant;
import Services.RestaurantService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author SBS
 */


 
public class ShowRestauController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
     @FXML
   

    /**
     * Initializes the controller class.
     */
    private List<Restaurant> regions = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        RestaurantService rs = new RestaurantService();

        int col = 0;
        int row = 0;

        try {
            for (Restaurant r : rs.display()) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("RestauItem.fxml"));

                AnchorPane anchorpane = fxmlLoader.load();

                RestauItemController itemController = fxmlLoader.getController();
                itemController.setData(r);

                if (col == 2) {
                    col = 0;
                    row++;
                }

                grid.add(anchorpane, col++, row);

                GridPane.setMargin(anchorpane, new Insets(10));
            }

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("RestauItem.fxml"));

            AnchorPane anchorpane = fxmlLoader.load();

            RestauItemController itemController = fxmlLoader.getController();
            itemController.setData();

            if (col == 2) {
                col = 0;
                row++;
            }

            grid.add(anchorpane, col++, row);

            GridPane.setMargin(anchorpane, new Insets(40, 10, 10, 10));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private static void loadPage(String page) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(BackRestaurantController.class.getResource(page + ".fxml"));

        HomePageController.hpc.getBp().setCenter(root);
    }

    public static void reload() {
        try {
            loadPage("ShowRestau");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void PDF(ActionEvent event) {

        try {

            FileChooser fileChooser = new FileChooser();

            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
            fileChooser.getExtensionFilters().add(extFilter);
            File f = fileChooser.showSaveDialog(Acceuil.primaryStage);

            OutputStream file = new FileOutputStream(f);
            Document document = new Document();

            PdfWriter.getInstance(document, file);

            document.open();
            List<Restaurant> res = new ArrayList<>();

            RestaurantService rs = new RestaurantService();
            res = rs.getall();

            PdfPTable tab = new PdfPTable(5);

            String txt = "<!-- #######  YAY, I AM THE SOURCE EDITOR! #########-->\n"
                    + "<h1 style=\"color: #5e9ca0;\"> <span style=\"color: #2b2301;\"></span> </h1>\n"
                    + "<h2 style=\"color: #2e6c80;\"></h2>\n"
                    + "<p> <br /></p>\n"
                    + "<p> <span style=\"background-color: #2b2301; color: #fff; display: inline-block; padding: 3px 10px; font-weight: bold; border-radius: 5px;\"></span> </p>\n"
                    + "<h2 style=\"color: #2e6c80;\"></h2>\n"
                    + "<ol style=\"list-style: none; font-size: 14px; line-height: 32px; font-weight: bold;\">\n"
                    + "<li style=\"clear: both;\">&nbsp;</li>\n"
                    + "</ol>\n"
                    + "<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</p>\n"
                    + "<h2 style=\"color: #2e6c80;\"></h2>\n"
                    + "<p>&nbsp;</p>\n"
                    + "<p><strong > </strong><br /><strong>Enjoy!</strong></p>\n"
                    + "<p><strong>&nbsp;</strong></p>";
            document.setHtmlStyleClass(txt);

            String url1 = getClass().getResource("images/" + "logo.png").toString();

            Image img1 = Image.getInstance(url1);
            img1.setAlignment(Image.RIGHT);

            document.add(img1);

            tab.addCell("Nom");
            tab.addCell("Num");
            tab.addCell("Horraire d'ouverture");
            tab.addCell("Horraire def ermeture");
            tab.addCell("Image");

            Paragraph p = new Paragraph("                                               LISTE DES RESTAURANTS :");

            p.setSpacingBefore(50);
            document.add(p);
            document.add(new Paragraph("                                             -------------------------------------------"));
            document.add(new Paragraph("                      "));
            document.add(new Paragraph("                      "));
            document.add(new Paragraph("                      "));

            document.add(new Paragraph("                      "));

            document.add(new Paragraph(""));
            document.add(new Paragraph(""));
            document.add(new Paragraph(""));
            document.setHtmlStyleClass(txt);

            for (int i = 0; i < res.size(); i++) {

                Restaurant resto = res.get(i);
                String nom = resto.getNom();
                String num = String.valueOf(resto.getNum());
                java.util.Date dated = resto.getHorraire_ouverture();
                java.util.Date datef = resto.getHorraire_ouverture();

                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                String strDate = dateFormat.format(dated);
                String strDate1 = dateFormat.format(datef);

                //String imageFile = resto.getImage() ;
                // ImageData data = ImageDataFactory.create(imageFile); 
                String url = getClass().getResource("images/" + resto.getImage()).toString();

                Image img = Image.getInstance(url);
                //System.out.println(resto.getImage());

                tab.addCell(nom);
                tab.addCell(num);
                tab.addCell(strDate);
                tab.addCell(strDate1);
                tab.addCell(img);

            }
            document.add(tab);

            document.close();

            System.out.println("your pdf has been created");
            file.close();

            //Desktop.getDesktop().open(new File("C:\\Users\\lenovo\\Desktop\\" ));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void gotoStat() throws IOException {
        loadPage("Statistiques");
    }

}
