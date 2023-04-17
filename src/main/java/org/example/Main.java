package org.example;

import Clases.Ronda;
import Util.ArchivoUtil;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        //Ubicación del archivo resultados.csv
        String archivo1 = "G:\\[ESTUDIOS - Cursos, Tecnicaturas, etc]\\[PROGRAMACION]\\Arg Prog 4.0\\JAVA\\TRABAJO INTEGRADOR\\TP-Integrador-Grupo11\\src\\main\\java\\Files\\resultados.csv";  //G:\[ESTUDIOS - Cursos, Tecnicaturas, etc]\[PROGRAMACION]\Arg Prog 4.0\JAVA\TRABAJO INTEGRADOR\TP-Integrador-Grupo11
        //Ubicación del archivo pronostico.csv
        String archivo2 = "G:\\[ESTUDIOS - Cursos, Tecnicaturas, etc]\\[PROGRAMACION]\\Arg Prog 4.0\\JAVA\\TRABAJO INTEGRADOR\\TP-Integrador-Grupo11\\src\\main\\java\\Files\\pronostico.csv";


        ArchivoUtil archivo = new ArchivoUtil(archivo1,archivo2);
        List<Ronda> ronda = archivo.getResultados(); // == RONDAS


        System.out.println("Cuantas rondas hay? " + ronda.size());


    }
}