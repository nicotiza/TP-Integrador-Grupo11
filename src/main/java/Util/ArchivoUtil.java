package Util;

import  Clases.Equipo;
import  Clases.Pronostico;
import  Clases.Partido;
import  Clases.Ronda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

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
    public static List<Ronda> getResultados() throws IOException{
        List<Ronda>     rondas   =   new ArrayList<>();
        List<Equipo>    equipos  =   new ArrayList<>();
        List<Partido>   partidos =   new ArrayList<>();

        //Lectura del archivo línea por línea.
        for (String linea : Files.readAllLines(Paths.get(urlResultadosCSV))) {
            String[] resultadosLinea = linea.split(",");

            Equipo equipo1 = null;
            int     goles1 = 0;
            Equipo equipo2 = null;
            int     goles2 = 0;
            Partido partido = null;
            Ronda ronda = null;

            //Evitar la primera línea que contiene los títulos de las columnas.
            if (!resultadosLinea[0].equals("Equipo_1")) {
                equipo1 = new Equipo(resultadosLinea[0].trim(), "");
                goles1 = parseInt(resultadosLinea[1]);
                equipo2 = new Equipo(resultadosLinea[3].trim(), "");
                goles2 = parseInt(resultadosLinea[2]);

                partido = new Partido(equipo1,equipo2,goles1,goles2);


                equipos.add(equipo1);
                equipos.add(equipo2);
                partidos.add(partido);

                ronda = new Ronda("1", partidos.toArray(new Partido[0]));
                rondas.add(ronda);
            }



        }
        return rondas;
    }

    public static List<Pronostico> getPronostico() throws IOException{


    return null;
    }

}
