package ua.kpi.fpm.model.entities.messageService.deliveryService;

/**
 * Created by Денис on 16.05.2016.
 */
public interface Sendable {

    SerializedMessage serialize() throws Exception;

    void deSerialize(SerializedMessage serializedMessage) throws Exception;

}
