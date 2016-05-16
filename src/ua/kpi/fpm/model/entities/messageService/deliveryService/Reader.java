package ua.kpi.fpm.model.entities.messageService.deliveryService;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Денис on 16.05.2016.
 */
public interface Reader {

        SerializedMessage read(InputStream in) throws IOException;

}
