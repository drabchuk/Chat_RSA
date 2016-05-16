package ua.kpi.fpm.model.entities.messageService.deliveryService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Денис on 16.05.2016.
 */
public class Delivery implements Sender, Reader {

    @Override
    public SerializedMessage read(InputStream in) throws IOException{
        byte[] data = new byte[in.available()];
        in.read(data);
        return new SerializedMessage(data);
    }

    @Override
    public void send(OutputStream outputStream, SerializedMessage message) throws IOException{
        outputStream.write(message.getData());
    }

}
