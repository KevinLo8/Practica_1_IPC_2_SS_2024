package com.practica_1.Backend.ConexiónArchivo;

import java.io.*;

public class ConexionArchivo {

    public static void guardarArchivo(String path, String data, String nombre) throws IOException {

        String pathName = path + "/" + nombre;
        File file = new File(pathName);

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.append(data);
        writer.close();
        fileWriter.close();
    }
}
