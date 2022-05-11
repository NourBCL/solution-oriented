/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

/**
 *
 * @author acer
 */
public class QRCODE implements Initializable {

    @FXML
    private ImageView qrView;

   
   public void initQrCode(String code)
   {
       System.out.println("my code is " + code);
       QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWeb = code;
        int width = 350;
        int height = 350;
        String fileType = "png";
        
        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
            
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
            
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            
            
            System.out.println("Success...");
            
        } catch (WriterException ex) {
            Logger.getLogger(QRCODE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
        
        
   }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
           


    }

  

    

  
    
    
    
    
    
}
