package ua.kpi.fpm.model.entities.messageService.messageTypes;

import ua.kpi.fpm.model.entities.messageService.deliveryService.Sendable;
import ua.kpi.fpm.model.entities.messageService.deliveryService.SerializedMessage;

import java.util.Date;

import static ua.kpi.fpm.model.entities.messageService.Charsets.STANDARD_CHARSET;

/**
 * Created by Денис on 16.05.2016.
 */
public class Message implements Sendable {

    Date date = new Date();
    MsgContent content;

    @Override
    public SerializedMessage serialize() throws Exception{
        return new SerializedMessage(this.toString().getBytes(STANDARD_CHARSET));
    }

    @Override
    public void deSerialize(SerializedMessage serializedMessage) throws Exception{
        this.content = new StringContent(serializedMessage.getData());
    }

    @Override
    public String toString() {
        return date.toString() + "\n\n" + content.getContent();
    }
}
