package ejercicios_obligatorios;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FuncionHash {

    public static void main(String[] args) {
        String text = "Hasta luego lucas!!";
        String hash = hashText(text);
        System.out.println("SHA-256 Hash: " + hash);
    }

    public static String hashText(String input) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = messageDigest.digest(input.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : hashBytes) {
                stringBuilder.append(String.format("%02x", b));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
