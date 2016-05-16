package ua.kpi.fpm.model.entities.messageService.deliveryService;

/**
 * Created by Денис on 16.05.2016.
 */
public class SerializedMessage {

    byte[] data;

    public SerializedMessage(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }
}
