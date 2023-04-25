package org.example;

import Clases.Equipo;
import Clases.Pronostico;
import Clases.Partido;
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
        List<Partido> partidos = archivo.getResultados(); // == retorna Lista de PARTIDOS
        List<Pronostico> pronosticos = archivo.getPronostico(partidos); //== retorna Lista de PRONOSTICOS
        int contPuntos=0;
        for(Pronostico p: pronosticos) {
            contPuntos+=p.puntos();
        }
        System.out.println("Puntaje= "+contPuntos);
    }
}