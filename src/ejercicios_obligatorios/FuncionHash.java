package ejercicios_obligatorios;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FuncionHash {

    public static void main(String[] args) {
        String text = "Hello, world!";
        String hash = hashText(text);
        System.out.println("SHA-256 Hash: " + hash);
    }

    public static String hashText(String input) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = messageDigest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
