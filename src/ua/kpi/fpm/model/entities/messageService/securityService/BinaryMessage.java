package ua.kpi.fpm.model.entities.messageService.securityService;

import ua.kpi.fpm.model.entities.messageService.deliveryService.SerializedMessage;
import ua.kpi.fpm.model.entities.messageService.messageTypes.MessageStr;

import static ua.kpi.fpm.model.entities.messageService.Charsets.*;

import java.io.*;
import java.math.BigInteger;

/**
 * Created by Денис on 15.05.2016.
 */
public class BinaryMessage {

    private BigInteger content;

    public BinaryMessage(BigInteger binNumber) {
        this.content = binNumber;
    }

    public BinaryMessage(SerializedMessage serMsg) {
        this.content = new BigInteger(serMsg.getData());
    }

    public BinaryMessage(MessageStr msg) throws IOException, ClassNotFoundException {
        String data = msg.getContent();
        byte[] bytes = data.getBytes(STANDARD_CHARSET);
        this.content = new BigInteger(bytes);
    }

    public MessageStr toMessage() throws IOException, ClassNotFoundException {
        String str = new String(this.content.toByteArray(), STANDARD_CHARSET);
        MessageStr msg = new MessageStr(str);
        return msg;
    }

    public BigInteger getContent() {
        return content;
    }

}
