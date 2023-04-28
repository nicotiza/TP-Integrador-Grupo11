package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
    private static String URL = "jdbc:mysql://localhost:3306/pronosticodeportivo?useSSL=false";
    private static String USUARIO = "root";
    private static String CONTRASENIA = "root";
    private static Connection conexion;


    public void conectar() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException("El controlador MySQL JDBC no se ha encontrado en el classpath.", e);
            }
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENIA);
        }
    }

    public void desconectar() throws SQLException {
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
        }
    }

    public ResultSet ejecutarConsulta(String sql) throws SQLException {
        conectar();
        Statement statement = conexion.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    /*public int ejecutarActualizacion(String sql) throws SQLException {
        conectar();
        Statement statement = conexion.createStatement();
        int filasAfectadas = statement.executeUpdate(sql);
        return filasAfectadas;
    }*/

    public Connection getConexion() {
        return conexion;
    }
}