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




        /*System.out.println("Cuantos partidos hay? " + partidos.size());
        System.out.println("El primer equipo es: " + partidos.get(0).getEquipo1().getNombreEquipo());
        System.out.println("Los goles del equipo fueron: " + partidos.get(0).getGolesEquipo1());
        System.out.println("El segundo equipo es: " + partidos.get(0).getEquipo2().getNombreEquipo());
        System.out.println("Los goles del equipo fueron: " + partidos.get(0).getGolesEquipo2());
        System.out.println("*_*_*_*_*_**_*_***");
        System.out.println("Resultado de "+ partidos.get(0).getEquipo1().getNombreEquipo() +": " + partidos.get(0).resultado(partidos.get(0).getEquipo1()));
        */


        System.out.println(partidos.get(2).resultado(partidos.get(2).getEquipo1()));


        for (Pronostico pronostico : pronosticos) {
            System.out.println(pronostico.getEquipo().getNombreEquipo());
            System.out.println(pronostico.getResultado());
            System.out.println(pronostico.puntos());
        }

        /*
        int contPuntos=0;
        for(Pronostico p: pronosticos) {
            contPuntos+=p.puntos();
        }
        System.out.println("Puntaje= "+contPuntos);
*/

        System.out.println("FIN");
    }
}