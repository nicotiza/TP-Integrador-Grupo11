package Dao;
import Clases.Partido;
import Clases.Pronostico;
import java.util.List;
public interface pronosticoDAO {
    List<Pronostico> obtenerTodos(List<Partido> partidos);
}
