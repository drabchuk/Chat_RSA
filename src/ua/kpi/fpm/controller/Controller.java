package ua.kpi.fpm.controller;

import ua.kpi.fpm.model.Model;
import ua.kpi.fpm.model.entities.User;
import ua.kpi.fpm.model.entities.messageService.deliveryService.SerializedMessage;
import ua.kpi.fpm.model.entities.messageService.messageTypes.Message;
import ua.kpi.fpm.model.entities.messageService.securityService.BinaryMessage;
import ua.kpi.fpm.model.entities.messageService.messageTypes.MessageStr;
import ua.kpi.fpm.view.View;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by User on 17.03.2016.
 */
public class Controller {

    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        User alice = new User(1L);
        User bob = new User(2L);

        MessageStr msg1 = new MessageStr("Hi i'm Alice");
        SerializedMessage encryptedMsg = alice.encryptMsg(msg1, bob.getPublicKey());
        try {
            bob.recieveEncryptedMessage(1L, encryptedMsg);
        } catch (IOException ioExc) {
            System.out.println("Bob can't recieve msg");
            ioExc.printStackTrace();
        } catch (ClassNotFoundException classExc) {
            System.out.println("Bob can't recieve msg");
            classExc.printStackTrace();
        } catch (Exception e) {
            System.out.println("Bob can't recieve msg\nUnknown exception");
            e.printStackTrace();
        }
        ArrayList<Message> bobMsgsFromAlice = bob.getAllMessagesFrom(1L);
        System.out.println("To Bob from Alice:");
        for (Message m: bobMsgsFromAlice) {
            System.out.println(m.toString());
        }
    }

}
