package Util;

import Clases.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static Clases.ResultadoEnum.*;
import static java.lang.Integer.parseInt;

public class ArchivoUtil {
//
    private static String urlResultadosCSV = "";
    private static String urlPronosticoCSV = "";

    public ArchivoUtil() {
    }
    public ArchivoUtil(String archivo1,String archivo2) {
        this.urlResultadosCSV = archivo1;
        this.urlPronosticoCSV = archivo2;
    }

    public static String getUrlResultadosCSV() {
        return urlResultadosCSV;
    }

    public static void setUrlResultadosCSV(String urlResultadosCSV) {
        ArchivoUtil.urlResultadosCSV = urlResultadosCSV;
    }

    public static String getUrlPronosticoCSV() {
        return urlPronosticoCSV;
    }

    public static void setUrlPronosticoCSV(String urlPronosticoCSV) {
        ArchivoUtil.urlPronosticoCSV = urlPronosticoCSV;
    }

    //Método para devolver las Rondas del archivo Resultado.csv con los datos de Equipos, Goles y arma los Partidos en cuestión.
    public static List<Partido> getResultados() throws IOException{
        List<Ronda>     rondas   =   new ArrayList<>();
        List<Equipo>    equipos  =   new ArrayList<>();
        List<Partido>   partidos =   new ArrayList<>();
        Ronda ronda = null;

        //Lectura del archivo línea por línea.
        for (String linea : Files.readAllLines(Paths.get(urlResultadosCSV))) {
            String[] resultadosLinea = linea.split(",");

            Equipo equipo1 = null;
            int     goles1 = 0;
            Equipo equipo2 = null;
            int     goles2 = 0;
            Partido partido = null;



            //Evitar la primera línea que contiene los títulos de las columnas.
            if (!resultadosLinea[0].equals("Equipo_1")) {
                equipo1 = new Equipo(resultadosLinea[0].trim(), "");        //La primer posición del nuevo array "resultadosLinea" se guarda en la variable equipo1. Sobreentendiendo que así es como está la estructura del archivo.
                goles1 = parseInt(resultadosLinea[1]);                               //Los goles del primer equipo se guarda en la variable goles1.
                equipo2 = new Equipo(resultadosLinea[3].trim(), "");        //El equipo 2 se guarda en la lista de equipos
                goles2 = parseInt(resultadosLinea[2]);                               //Los goles del primer equipo se guarda en la variable goles2.

                partido = new Partido(equipo1,equipo2,goles1,goles2);               //Se crea el partido con ambos equipos y goles.


                equipos.add(equipo1);       //Se guarda equipo1 en lista equipos.
                equipos.add(equipo2);       //Se guarda equipo2 en lista equipos.
                partidos.add(partido);      //Se guarda el partido en la lista partidos.
            }

        }
        return partidos;
    }

    public static Partido buscarPartido(List<Partido> partidos,Equipo team1, Equipo team2) {
        Partido aux= new Partido();
        for(Partido partido: partidos) {
            if((partido.getEquipo1().equals(team1) || partido.getEquipo2().equals(team1))&&(partido.getEquipo1().equals(team2) || partido.getEquipo2().equals(team2))) {
                aux=partido;
            }
        }

        return aux;
    }
    public static List<Pronostico> getPronostico(List<Partido> partidos) throws IOException{
        List<Pronostico> pronosticos = new ArrayList<>();
        for (String linea : Files.readAllLines(Paths.get(urlPronosticoCSV))) {
            String[] pronosticoLinea = linea.split(",");

            Equipo equipo = null;
            ResultadoEnum resultado = null;

            if (linea.contains("X")){
                if (pronosticoLinea[1].equals("X")){
                    equipo = new Equipo(pronosticoLinea[0],"");
                    resultado = GANADOR;
                } else if (pronosticoLinea[2].equals("X")) {
                    equipo = new Equipo(pronosticoLinea[0],"");
                    resultado = EMPATE;
                } else if (pronosticoLinea[3].equals("X")){
                    equipo = new Equipo(pronosticoLinea[0],"");
                    resultado = PERDEDOR;
                }
            }
            Equipo equipo2 = new Equipo(pronosticoLinea[4],"");
            Pronostico pronostico = new Pronostico(buscarPartido(partidos,equipo,equipo2),equipo,resultado);
            pronosticos.add(pronostico);
        }
        return pronosticos;
    }

}
