package ua.kpi.fpm.model.entities.messageService.securityService.binary.rsaLib;

import ua.kpi.fpm.model.entities.messageService.deliveryService.SerializedMessage;
import ua.kpi.fpm.model.entities.messageService.messageTypes.Message;
import ua.kpi.fpm.model.entities.messageService.securityService.Key;
import ua.kpi.fpm.model.entities.messageService.messageTypes.MessageStr;
import ua.kpi.fpm.model.entities.messageService.securityService.SecurityService;
import ua.kpi.fpm.model.entities.messageService.securityService.BinaryMessage;

import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by Денис on 15.05.2016.
 */
public class RSASecurityService implements SecurityService {
    KeysSafe keysSafe;

    public RSASecurityService() {
        keysSafe = new KeysSafe();
    }

    @Override
    public SerializedMessage encrypt(Message msg, Key key) throws Exception {
        SerializedMessage serMsg = msg.serialize();
        BinaryMessage binMsg = new BinaryMessage(serMsg);
        BigInteger encodedBI = Encoder.encode(binMsg.getContent(), key);
        BinaryMessage encodedMsg = new BinaryMessage(encodedBI);
        return new SerializedMessage(encodedBI.toByteArray());
    }

    @Override
    public Message decrypt(SerializedMessage serMsg) throws Exception {
        byte[] data = serMsg.getData();

        BigInteger cipher = new BigInteger(data);
        BigInteger decodedCipher = keysSafe.decode(cipher);
        //BinaryMessage decodedMsg = new BinaryMessage(decodedCipher);

        byte[] deCodedData = decodedCipher.toByteArray();
        SerializedMessage smsg = new SerializedMessage(deCodedData);
        Message m = new Message();
        m.deSerialize(smsg);
        return m;
    }

    @Override
    public Key getPublicKey() {
        return keysSafe.getPublicKey();
    }

    public void updateKeys() {
        keysSafe = new KeysSafe();
    }
}
