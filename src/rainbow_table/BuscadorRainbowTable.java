package rainbow_table;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BuscadorRainbowTable {
    // Función para buscar el hash en la Rainbow Table
    public static String buscarPass(String hash, String rainbowTableFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rainbowTableFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] partes = line.split(" ");
                String pass = partes[0];
                String hashGuardado = partes[1];
                if (hashGuardado.equals(hash)) {
                    return pass;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String hashAEncontrar = "a91b2fcd5820bffcc1028b32187fdf232d8c093dcf3ab3789b42e623d9dbd81f"; // Hash de prueba
        String ficheroRainbow = "rainbow_table.txt"; // Archivo donde está la tabla arcoíris

        String pass = buscarPass(hashAEncontrar, ficheroRainbow);
        if (pass != null) {
            System.out.println("El hash corresponde a la contraseña: " + pass);
        } else {
            System.out.println("Hash no encontrado en la Rainbow Table.");
        }
    }
}
