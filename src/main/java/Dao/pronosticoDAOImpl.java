package Dao;
import Clases.Equipo;
import Clases.Partido;
import Clases.Pronostico;
import Clases.ResultadoEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Clases.ResultadoEnum.GANADOR;
import static Clases.ResultadoEnum.EMPATE;
import static Clases.ResultadoEnum.PERDEDOR;
import static Util.ArchivoUtil.buscarPartido;

public class pronosticoDAOImpl extends DAO implements pronosticoDAO{
    private static final String OBTENER_TODOS = "SELECT * FROM pronosticos";

    @Override
    public List<Pronostico> obtenerTodos(List<Partido> partidos) {
        List<Pronostico> pronosticos = new ArrayList<>();

        try {
            ResultSet resultSet = ejecutarConsulta(OBTENER_TODOS);
            while (resultSet.next()) {
                String equipo1 = resultSet.getString("equipo1"); //equipo1 = new Equipo(resultadosLinea[0].trim(), "");
                String gana1 = resultSet.getString("gana1");
                String empate = resultSet.getString("empate");
                String gana2 = resultSet.getString("gana2");
                String equipo2 = resultSet.getString("equipo2");

                Equipo EquipoA = new Equipo(equipo1,""); //Genero el objeto Equipo con el primer equipo de la tabla.
                Equipo EquipoB = new Equipo(equipo2,"");

                ResultadoEnum resultado = null;
                //
                if (gana1.equals("X")) {
                    resultado = GANADOR;
                } else if (empate.equals("X")){
                    resultado = EMPATE;
                } else if (gana2.equals("X")) {
                    resultado = PERDEDOR;
                }


                Pronostico pronostico = new Pronostico(buscarPartido(partidos,EquipoA,EquipoB),EquipoA,resultado);
                pronosticos.add(pronostico);
            }
            desconectar();
        } catch (SQLException e) {
            System.out.println("Error al obtener los pronosticos: " + e.getMessage());
        }
        return pronosticos;
    }


}
