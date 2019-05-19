package pkg;

import java.math.BigInteger;

public class Decrypt {
    public static String decodeEncrypted(BigInteger[] c,BigInteger d, BigInteger p, BigInteger q) {
        ExtEuclidean ex = new ExtEuclidean();
        long[] temp = new long[c.length];

        String demes = "";

        BigInteger cp, cq;
        ex.EXTEuclidean(p , q);

        for(int i = 0; i < c.length; i++){
            cp = fastPower.power(c[i] , d.mod(p.subtract(BigInteger.ONE)),p);
            cq = fastPower.power(c[i] , d.mod(q.subtract(BigInteger.ONE)),q);

            temp[i] = (((p.multiply(cp).multiply(ex.X)).add(q.multiply(cq).multiply(ex.Y))).mod(p.multiply(q))).longValue();
        }



        for (int i = 0; i < c.length; i++){
            demes += (char) temp[i];
        }
        return demes;
    }

}

