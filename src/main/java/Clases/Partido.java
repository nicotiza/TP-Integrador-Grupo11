package Clases;

public class Partido {

    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;


    public Partido(){

    }

    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public ResultadoEnum resultado(Equipo equipo) {
        ResultadoEnum res=null;
        if(equipo.getNombreEquipo().equals(equipo1.getNombreEquipo())) {
            if(golesEquipo1>golesEquipo2) {
                res= ResultadoEnum.GANADOR;
            }else if(golesEquipo1==golesEquipo2) {
                res= ResultadoEnum.EMPATE;
            }else {
                res= ResultadoEnum.PERDEDOR;
            }
        }else if(equipo.getNombreEquipo().equals(equipo2.getNombreEquipo())) {
            if(golesEquipo1<golesEquipo2) {
                res= ResultadoEnum.GANADOR;
            }else if(golesEquipo1==golesEquipo2) {
                res= ResultadoEnum.EMPATE;
            }else {
                res= ResultadoEnum.PERDEDOR;
            }
        }
        return res;
    }
}
