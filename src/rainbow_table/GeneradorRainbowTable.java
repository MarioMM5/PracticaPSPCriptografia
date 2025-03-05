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

    // Función para generar la Rainbow Table
    public static void generateRainbowTable(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {
            String password;
            while ((password = reader.readLine()) != null) {
                String hashPass = hashText(password);
                writer.write(password + " " + hashPass + "\n");
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
