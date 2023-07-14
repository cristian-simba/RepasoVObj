import java.io.Serializable;


public class Datos implements Serializable {
    String marca;
    Double velocidad;
    int anio;

    public Datos(String marca, Double velocidad, int anio) {
        this.marca = marca;
        this.velocidad = velocidad;
        this.anio = anio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    public String toString(){
        return "Marca: "+marca+"Velocidad: "+velocidad+"Año: "+anio;
    }

}
