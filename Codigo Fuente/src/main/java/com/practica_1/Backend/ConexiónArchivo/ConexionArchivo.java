package com.practica_1.Backend.ConexiónArchivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ConexionArchivo {

    public static void guardarArchivo(String path, String data, String nombre){

        File file = new File(path + "/" + nombre);

        try (FileWriter fileWriter = new FileWriter(file);
                BufferedWriter writer = new BufferedWriter(fileWriter);) {
            writer.append(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
