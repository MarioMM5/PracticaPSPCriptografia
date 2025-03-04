package rainbow_table;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BuscadorRainbowTable {
    // Función para buscar el hash en la Rainbow Table
    public static String findPassword(String hash, String rainbowTableFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rainbowTableFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String password = parts[0];
                String storedHash = parts[1];
                if (storedHash.equals(hash)) {
                    return password;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String hashToFind = "a91b2fcd5820bffcc1028b32187fdf232d8c093dcf3ab3789b42e623d9dbd81f"; // Hash de prueba
        String rainbowTableFile = "rainbow_table.txt"; // Archivo donde está la tabla arcoíris

        String password = findPassword(hashToFind, rainbowTableFile);
        if (password != null) {
            System.out.println("El hash corresponde a la contraseña: " + password);
        } else {
            System.out.println("Hash no encontrado en la Rainbow Table.");
        }
    }
}
