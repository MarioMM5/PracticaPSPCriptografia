package ejercicios_obligatorios;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class CifradoSimetrico {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String originalText = sc.nextLine();
            String secretKey = "1234567890123456"; // 16 bytes clave para AES-128
            String encryptedText = encrypt(originalText, secretKey);
            String decryptedText = decrypt(encryptedText, secretKey);

            System.out.println("Original: " + originalText);
            System.out.println("Encrypted: " + encryptedText);
            System.out.println("Decrypted: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String plainText, String secretKey) throws Exception {
        SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Desencriptado de texto
    public static String decrypt(String encryptedText, String secretKey) throws Exception {
        SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

}
