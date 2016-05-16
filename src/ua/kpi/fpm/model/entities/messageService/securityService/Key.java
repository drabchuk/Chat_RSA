package ua.kpi.fpm.model.entities.messageService.securityService;

import java.math.BigInteger;

/**
 * Created by Денис on 14.05.2016.
 */
public class Key{
    private final BigInteger e;
    private final BigInteger n;

    public Key(BigInteger e, BigInteger n) {
        this.e = e.abs();
        this.n = n.abs();
    }

    public BigInteger getE() {
        return e.abs();
    }

    public BigInteger getN() {
        return n.abs();
    }
}
