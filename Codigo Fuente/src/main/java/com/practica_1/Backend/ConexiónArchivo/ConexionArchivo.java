package com.practica_1.Backend.ConexiónArchivo;

import java.io.*;

import com.practica_1.Backend.Exception.ArchivoExistenteException;

public class ConexionArchivo {

    public static void guardarArchivo(String path, String data, String nombre) throws IOException, ArchivoExistenteException {

        String pathName = path + "/" + nombre;
        File file = new File(pathName);

        if (file.exists()) {
            throw new ArchivoExistenteException();
        }

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.append(data);
        writer.close();
        fileWriter.close();
    }
}
