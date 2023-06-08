import java.util.Objects;
import java.util.Random;

public class Registro {
    private String dni;
    private Double temperatura;

    public Registro() {
    }
    public Registro(String dni) {
        this.dni = dni;
        this.temperatura = temperatura;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        Double generarTemperaturaAleatoria = null;
        this.temperatura = generarTemperaturaAleatoria;
    }

    public double generarTemperaturaAleatoria() {
        Random random = new Random();
        double minTemperatura = 36.0;
        double maxTemperatura = 39.0;
        double temperaturaAleatoria = minTemperatura + (maxTemperatura - minTemperatura) * random.nextDouble();
        return temperaturaAleatoria;
    }

    public void verRegistro(){
        System.out.println("DNI: "+getDni());
        System.out.println("Temperatura: "+getTemperatura()+"ºC");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registro registro = (Registro) o;
        return dni.equals(registro.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}
