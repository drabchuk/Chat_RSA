package ua.kpi.fpm.model.entities.messageService.deliveryService;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Денис on 16.05.2016.
 */
public interface Sender {

    void send(OutputStream outputStream, SerializedMessage message) throws IOException;

}
