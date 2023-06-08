public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
    private String barrio;
    private String ocupacion;
    private Registro registro;
    private Integer kitAsignado;

    public Persona(String nombre, String apellido, Integer edad, String barrio, String ocupacion, Registro registro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.barrio = barrio;
        this.ocupacion = ocupacion;
        this.kitAsignado = kitAsignado;
        this.registro = registro;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getKitAsignado() {
        return kitAsignado;
    }

    public void setKitAsignado(Integer kitAsignado) {
        this.kitAsignado = kitAsignado;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }


    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", barrio='" + barrio + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                ", kitAsignado=" + kitAsignado +
                '}';
    }
}
