package Util;

import Clases.*;
import Clases.Partido;

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
            if (!resultadosLinea[0].equals("EQUIPO_1")) {
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

    public static Partido buscarPartido(List<Partido> partidos,Equipo equipo1, Equipo equipo2) {
        Partido aux= new Partido();

        for(int i=0; i<partidos.size();i++){
            String auxEQ1 = partidos.get(i).getEquipo1().getNombreEquipo();
            String auxEQ2 = partidos.get(i).getEquipo2().getNombreEquipo();
            String equipo_1 = equipo1.getNombreEquipo();
            String equipo_2 = equipo2.getNombreEquipo();

            if( auxEQ1.equals(equipo_1) && auxEQ2.equals(equipo_2) ){
                aux.setEquipo1(partidos.get(i).getEquipo1());
                aux.setEquipo2(partidos.get(i).getEquipo2());
                aux.setGolesEquipo1(partidos.get(i).getGolesEquipo1());
                aux.setGolesEquipo2(partidos.get(i).getGolesEquipo2());
            }
        }

        //El FOR siguiente, es el FOR EACH que deberíamos usar. Reemplaza el código del FOR de arriba.

        /*for(Partido list: partidos) {

            String auxEQ1 = list.getEquipo1().getNombreEquipo();
            String auxEQ2 = list.getEquipo2().getNombreEquipo();
            String equipo_1 = equipo1.getNombreEquipo();
            String equipo_2 = equipo2.getNombreEquipo();

            if (
                    (auxEQ1.equals(equipo_1) || auxEQ1.equals(equipo_2))
                    &&
                    (auxEQ2.equals(equipo_1) || auxEQ2.equals(equipo_2))
            ){
                aux=list;
            }
        }*/
        return aux;
    }

    public static List<Pronostico> getPronostico(List<Partido> partidos) throws IOException{
        List<Pronostico> pronosticos = new ArrayList<>();
        for (String linea : Files.readAllLines(Paths.get(urlPronosticoCSV))) {
            String[] pronosticoLinea = linea.split(",");

            Equipo equipo1 = null;
            ResultadoEnum resultado = null;

            if (linea.contains("X")){
                if (pronosticoLinea[1].equals("X")){
                    equipo1 = new Equipo(pronosticoLinea[0],"");
                    resultado = GANADOR;
                } else if (pronosticoLinea[2].equals("X")) {
                    equipo1 = new Equipo(pronosticoLinea[0],"");
                    resultado = EMPATE;
                } else if (pronosticoLinea[3].equals("X")){
                    equipo1 = new Equipo(pronosticoLinea[0],"");
                    resultado = PERDEDOR;
                }
            }
            Equipo equipo2 = new Equipo(pronosticoLinea[4],"");
            Pronostico pronostico = new Pronostico(buscarPartido(partidos,equipo1,equipo2),equipo1,resultado);
            pronosticos.add(pronostico);
        }
        return pronosticos;
    }

}
