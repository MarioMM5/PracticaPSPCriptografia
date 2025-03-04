package rainbow_table;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeneradorRainbowTable {

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

    // Función para generar la Rainbow Table
    public static void generateRainbowTable(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {
            String password;
            while ((password = reader.readLine()) != null) {
                String hashedPassword = hashText(password);
                writer.write(password + " " + hashedPassword + "\n");
            }
            System.out.println("Rainbow Table generada exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String inputFile = "passwords.txt"; // Lista de contraseñas posibles
        String outputFile = "rainbow_table.txt"; // Archivo de salida
        generateRainbowTable(inputFile, outputFile);
    }
}
