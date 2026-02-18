import java.util.ArrayList;

public class Piloto {
    private String nombre;
    private String escuderia;
    private int puntos;

    public Piloto(String nombre, String escuderia, int puntos) {
        this.nombre = nombre;
        this.escuderia = escuderia;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
