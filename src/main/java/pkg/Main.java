package pkg;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        KeyPair keys = new KeyPair();
        keys.PrimePair();

        System.out.println("Az n: "+keys.n+"\nA d: "+keys.d+"\nAz e: "+keys.e);

        System.out.print("Add meg a titkosítandó üzenetet: ");
        String message=sc.nextLine();

        System.out.println("A kódolt üzenet: ");
        BigInteger[] crypted=Encrypt.Encryption(keys,message);
        for (int i = 0; i < crypted.length; i++) {
            System.out.print(crypted[i]);
        }
        System.out.println("\n");

        System.out.println("A visszakódolt üzenet: ");
        String publicmes = Decrypt.decodeEncrypted(crypted, keys.d, keys.p, keys.q);
        System.out.println(publicmes);
    }
}