package ua.kpi.fpm.model.entities.messageService.securityService;

import ua.kpi.fpm.model.entities.messageService.deliveryService.SerializedMessage;
import ua.kpi.fpm.model.entities.messageService.messageTypes.Message;
import ua.kpi.fpm.model.entities.messageService.messageTypes.MessageStr;

import java.io.IOException;

/**
 * Created by Денис on 15.05.2016.
 */
public interface SecurityService {
    SerializedMessage encrypt(Message decryptedMessage, Key key) throws Exception;
    Message decrypt(SerializedMessage encryptedMessage) throws Exception;
    Key getPublicKey();
}
