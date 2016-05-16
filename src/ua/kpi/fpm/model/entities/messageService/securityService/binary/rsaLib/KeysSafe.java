package ua.kpi.fpm.model.entities.messageService.securityService.binary.rsaLib;

import ua.kpi.fpm.model.entities.messageService.securityService.Key;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Денис on 14.05.2016.
 */
public class KeysSafe {
    private static final int STANDARD_BIT_LENGTH = 1024;
    private static final int STANDARD_CERTAINTY = 16;
    private static final int STANDARD_PUBLIC_EXP = 65537;
    private static final String STANDARD_PUBLIC_EXP_STR = "65537";
    private static final String SMALL_PUBLIC_EXP_STR = "17";

    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger euler;
    private BigInteger e;
    private BigInteger d;

    public KeysSafe() {
        generateRandomPrimes(STANDARD_BIT_LENGTH, STANDARD_CERTAINTY);
    }

    public KeysSafe(int bitLength, int certainty) {
        generateRandomPrimes(bitLength, certainty);
    }

    private void generateRandomPrimes(int bitLength, int certainty) {
        p = new BigInteger(bitLength, certainty, new Random());
        q = new BigInteger(bitLength, certainty, new Random());

        n = p.multiply(q);

        euler = eulerFunction(p, q);

        e = generatePublicExp(euler);

        d = e.modInverse(euler);
    }

    public BigInteger decode(BigInteger cipher) {
        return Decoder.decode(cipher, getPrivateKey());
    }

    public Key getPublicKey() {
        return new Key(e.abs(), n.abs());
    }

    private Key getPrivateKey() {
        return new Key(d.abs(), n.abs());
    }

    private BigInteger gcdex(BigInteger a, BigInteger b,
                             BigInteger x, BigInteger y) {
        if(a.compareTo(BigInteger.ZERO) == 0) {
            x = BigInteger.ZERO;
            y = BigInteger.ONE;
            return b;
        } else {
            BigInteger x1 = BigInteger.ZERO;
            BigInteger y1 = BigInteger.ZERO;
            BigInteger d = gcdex(b.mod(a), a, x1, y1);
            x = y1.subtract( (b.divide(a)).multiply(x1) );
            y = x1;
            return d;
        }
    }

    private BigInteger eulerFunction(final BigInteger p, final BigInteger q) {
        BigInteger pDecr = p.abs().subtract(BigInteger.ONE);
        BigInteger qDecr = q.abs().subtract(BigInteger.ONE);
        return pDecr.multiply(qDecr);
    }

    private BigInteger generatePublicExp(BigInteger euler) {
        BigInteger pe = new BigInteger(STANDARD_PUBLIC_EXP_STR);
        while (!pe.gcd(euler).equals(BigInteger.ONE)) {
            pe = pe.nextProbablePrime();
        }
        return pe;
    }
}
