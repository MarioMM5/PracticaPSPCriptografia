package rainbow_table;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el hash a encontrar:");
        String hashAEncontrar = sc.nextLine(); // Hash de prueba
        String ficheroRainbow = "rainbow_table.txt"; // Archivo donde está la tabla arcoíris

        String pass = buscarPass(hashAEncontrar, ficheroRainbow);
        if (pass != null) {
            System.out.println("El hash corresponde a la contraseña: " + pass);
        } else {
            System.out.println("Hash no encontrado en la Rainbow Table.");
        }
    }
}
