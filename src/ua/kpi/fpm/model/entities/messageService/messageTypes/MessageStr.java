package ua.kpi.fpm.model.entities.messageService.messageTypes;

import ua.kpi.fpm.model.entities.messageService.deliveryService.SerializedMessage;

import static ua.kpi.fpm.model.entities.messageService.Charsets.*;

import java.io.*;
import java.util.Date;

/**
 * Created by Денис on 14.05.2016.
 */
public class MessageStr extends Message{
    String content;

    public MessageStr(String content) {
        this.content = content;
        this.date = new Date();
    }

    public MessageStr(byte[] bytes) throws UnsupportedEncodingException{
        this.content = new String(bytes, STANDARD_CHARSET);
    }

    public String getContent() {
        return content;
    }

    public byte[] toByteArray() {
        try {
            return content.getBytes(STANDARD_CHARSET);
        } catch (IOException ioExc) {
            ioExc.printStackTrace();
        }
        return null;
    }

    @Override
    public SerializedMessage serialize() throws Exception{
        return new SerializedMessage(this.content.getBytes(STANDARD_CHARSET));
    }

    @Override
    public void deSerialize(SerializedMessage serializedMessage) throws Exception {
        this.content = new String(serializedMessage.getData());
    }

    @Override
    public String toString() {
        return date.toString() + "\n" + content;
    }
}
