package ua.kpi.fpm.model.entities.messageService.securityService.binary.rsaLib;

import ua.kpi.fpm.model.entities.messageService.securityService.Key;

import java.math.BigInteger;

/**
 * Created by Денис on 15.05.2016.
 */
public abstract class Decoder {

    public static BigInteger decode(BigInteger msgData, Key privateKey) {
        return msgData.modPow(privateKey.getE(), privateKey.getN());
    }

}
