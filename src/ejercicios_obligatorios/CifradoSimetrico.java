package ejercicios_obligatorios;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class CifradoSimetrico {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String texto = sc.nextLine();
            String secretKey = "1234567890123456"; // 16 bytes clave para AES-128
            String textoEncriptado = encriptar(texto, secretKey);
            String textoDesencriptado = decrypt(textoEncriptado, secretKey);

            System.out.println("Original: " + texto);
            System.out.println("Encriptado: " + textoEncriptado);
            System.out.println("Desencriptado: " + textoDesencriptado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encriptar(String plainText, String secretKey) throws Exception {
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
        byte[] bytesDecodificados = Base64.getDecoder().decode(encryptedText);
        byte[] bytesDesencriptados = cipher.doFinal(bytesDecodificados);
        return new String(bytesDesencriptados);
    }

}
