package ua.kpi.fpm.model.entities;

import ua.kpi.fpm.model.entities.messageService.MessageBox;
import ua.kpi.fpm.model.entities.messageService.deliveryService.SerializedMessage;
import ua.kpi.fpm.model.entities.messageService.messageTypes.Message;
import ua.kpi.fpm.model.entities.messageService.securityService.Key;
import ua.kpi.fpm.model.entities.messageService.messageTypes.MessageStr;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Денис on 14.05.2016.
 */
public class User {
    private long id;
    private MessageBox messageBox;

    public User(long id) {
        this.id = id;
        messageBox = new MessageBox(String.valueOf(id));
    }

    public Key getPublicKey() {
        return messageBox.getPublicKey();
    }

    public Message recieveEncryptedMessage(long fromId, SerializedMessage message)
            throws Exception {
        Message decoded = messageBox.readEncryptedMessage(fromId, message);
        return decoded;
    }

    public SerializedMessage encryptMsg(MessageStr msg, Key foreignKey) {
        try {
            return messageBox.encryptMessage(msg, foreignKey);
        } catch (IOException ioExc) {
            System.out.println("can't encrypt msg");
            ioExc.printStackTrace();
        } catch (ClassNotFoundException classNotFoundExc) {
            System.out.println("can't encrypt msg, class mot found");
            classNotFoundExc.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unknown exception!");
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Message> getAllMessagesFrom(long userId) {
        return messageBox.getAllMessagesFrom(userId);
    }

}
