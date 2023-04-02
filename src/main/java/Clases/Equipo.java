package Clases;

public class Equipo {
    private String nombreEquipo;
    private String descEquipo;

    public Equipo(String nombreEquipo, String descEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.descEquipo = descEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getDescEquipo() {
        return descEquipo;
    }

    public void setDescEquipo(String descEquipo) {
        this.descEquipo = descEquipo;
    }



}
