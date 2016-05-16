package ua.kpi.fpm.model.entities.messageService.securityService.binary.rsaLib;

import ua.kpi.fpm.model.entities.messageService.securityService.Key;

import java.math.BigInteger;

/**
 * Created by Денис on 15.05.2016.
 */
public abstract class Encoder {

    public static BigInteger encode(BigInteger messageData, Key publicKey) {
        return messageData.modPow(publicKey.getE(), publicKey.getN());
    }

}
