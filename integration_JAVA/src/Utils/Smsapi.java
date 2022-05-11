/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


/**
 *
 * @author omaro
 */
public class Smsapi {
    


    public static final String ACCOUNT_SID = "ACbaab9a65409145e9ab760ea34a9d90c5";
    public static final String AUTH_TOKEN = "d66a3fdf86d55495b6d2eba43986f071";

    public static void sendSMS( String msg) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(new PhoneNumber("+21652892836"),new PhoneNumber("+19402908245"), msg).create();

        System.out.println(message.getSid());

    }

}
    

