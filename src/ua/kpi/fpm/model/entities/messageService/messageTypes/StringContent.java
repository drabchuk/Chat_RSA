package ua.kpi.fpm.model.entities.messageService.messageTypes;
import java.io.UnsupportedEncodingException;

import static ua.kpi.fpm.model.entities.messageService.Charsets.*;

/**
 * Created by Денис on 16.05.2016.
 */
public class StringContent implements MsgContent {

    String data;

    public StringContent(byte[] byteStr) throws UnsupportedEncodingException{

        data = new String(byteStr, STANDARD_CHARSET);

    }

    @Override
    public String getContent() {
        return getData();
    }

    public StringContent(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }


}
