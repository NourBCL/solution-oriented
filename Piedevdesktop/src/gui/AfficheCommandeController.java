/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.stripe.Stripe;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PaymentLinkCreateParams;
import entite.Commande;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import service.CommandeService;
import util.Smsapi;

/**
 * FXML Controller class
 *
 * @author omaro
 */
public class AfficheCommandeController implements Initializable {

    @FXML
    private TextField a;
    @FXML
    private TextField b;
    @FXML
    private TextField c;
    @FXML
    private Button pay;
    
    private Commande commande;
    @FXML
    private Button del;
    
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setCommande(Commande p){
    a.setText(String.valueOf(p.getId()));
    b.setText(p.getAdresse_destination());
    c.setText( String.valueOf(p.getDate_commande()));
    commande =p;
    
    }

    @FXML
    private void payer(ActionEvent event) {
        //here miselech
                Stripe.apiKey = "sk_test_51KYa6PLo1XxC5WhZyg2Otw67MjDhJDnpHNl8xkmxy1NWrSfruIFMnyikQJFh4upAkIrCaISvyV7jlZy8vOEJBlte00MXskCbZg";
Smsapi.sendSMS(commande.toString()+"est en train d'etre eeu un mail contenant un lien de la  facture ");
        try {
            //Creation Produit
            Map<String, Object> productParams = new HashMap<>();
            productParams.put("name", "commande "+commande.getId());   
            Product product = Product.create(productParams);
            //Creation Prix
             Map<String, Object> priceParams = new HashMap<>();
             priceParams.put("unit_amount",100 );
priceParams.put("currency", "eur");
priceParams.put("product", product.getId());

Price price = Price.create(priceParams);
                 List<Object> lineItems = new ArrayList<>();
        Map<String, Object> lineItem1 = new HashMap<>();
        lineItem1.put(
          "price",
          price.getId()
        );
             PaymentLinkCreateParams paymentLinkCreateParams = PaymentLinkCreateParams.builder()
                
                .addLineItem(PaymentLinkCreateParams.LineItem.builder()
                
                .setPrice(price.getId())
                .setQuantity(1L)
                        
                        .build()
                ).setAfterCompletion(PaymentLinkCreateParams.AfterCompletion.builder()
                .setType(PaymentLinkCreateParams.AfterCompletion.Type.HOSTED_CONFIRMATION)
                        .setHostedConfirmation(new PaymentLinkCreateParams.AfterCompletion.HostedConfirmation.Builder().setCustomMessage("Paid").build()).build())
              
                .build();
        PaymentLink paymentLink =
          PaymentLink.create(paymentLinkCreateParams);
        
       
       
        //Redirect to URL
            String url =paymentLink.getUrl();

          

           URI uri= new URI(paymentLink.getUrl());
              
           java.awt.Desktop.getDesktop().browse(uri);
           System.out.println("Web page opened in browser");
        } catch (Exception ex) {
            Logger.getLogger(AfficheCommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void delete(ActionEvent event) {
       Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure !");
        //alert.show();
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == (ButtonType.OK)) {
          
            CommandeService sv = new  CommandeService();
            //Commande r = sv.recuperer(String.valueOf(p.getId()));
            sv.supprimer(commande.getId());

            }
    }
}
