package ua.kpi.fpm.model.entities.messageService;

import ua.kpi.fpm.model.entities.messageService.deliveryService.SerializedMessage;
import ua.kpi.fpm.model.entities.messageService.messageTypes.Message;
import ua.kpi.fpm.model.entities.messageService.securityService.Key;
import ua.kpi.fpm.model.entities.messageService.messageTypes.MessageStr;
import ua.kpi.fpm.model.entities.messageService.securityService.SecurityService;
import ua.kpi.fpm.model.entities.messageService.securityService.binary.rsaLib.RSASecurityService;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Денис on 14.05.2016.
 */
public class MessageBox {
    public final String address;

    HashMap<Long, ArrayList<Message>> msgMap = new HashMap<>();
    SecurityService securityService = new RSASecurityService();

    public MessageBox(String address) {
        this.address = address;
    }

    public Key getPublicKey() {
        return securityService.getPublicKey();
    }

    /**
     * Add decrypted msg to box (ArrayList)
     *
     * @return decrypted message
     */
    public Message readEncryptedMessage(long fromId, SerializedMessage message)
            throws Exception {

        Message decoded = securityService.decrypt(message);
        if (msgMap.containsKey(fromId)) {
            msgMap.get(fromId).add(decoded);
        } else {
            msgMap.put(fromId, new ArrayList<>());
            msgMap.get(fromId).add(decoded);
        }
        return decoded;
    }

    public SerializedMessage encryptMessage(MessageStr message, Key publicKey)
            throws Exception {

        return securityService.encrypt(message, publicKey);
    }

    public ArrayList<Message> getAllMessagesFrom(long userId) {
        return msgMap.get(userId);
    }

}
