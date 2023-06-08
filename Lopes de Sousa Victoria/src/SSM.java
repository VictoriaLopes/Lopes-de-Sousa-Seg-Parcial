import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.*;

public class SSM {
    private String nombre;
    Queue<Persona> porLlegada;//porque es por llegada
    private int cantidadTest;

    public SSM(String nombre) {
        this.porLlegada = new LinkedList<>();
        this.cantidadTest = cantidadTest;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadTest() {
        return cantidadTest;
    }

    public void setCantidadTest(int cantidadTest) {
        this.cantidadTest = cantidadTest;
    }

    public Queue<Persona> getPorLlegada() {
        return porLlegada;
    }

    public void setPorLlegada(Queue<Persona> porLlegada) {
        this.porLlegada = porLlegada;
    }

    public void agregarPersona(Persona persona){
        try{
            if(kidDisponibles(persona)){
                if(dniExiste(persona.getRegistro().getDni())){
                    System.out.println("DNI ya existente");
                }else{
                    porLlegada.add(persona);
                    System.out.println(" agregada");
                }
            }
        }catch(Exception e){
            System.out.println("Sin kit asignado");

        }
    }

    private boolean dniExiste(String dni) {
        return false;
    }


    public boolean kidDisponibles(Persona persona) throws sinTestDisponibles{
        boolean disponible;
        if(persona.getKitAsignado()!=null){
            disponible = true;
        }else{
            disponible = false;
            throw new sinTestDisponibles();
        }
        return disponible;
    }

    public static void guardarPersonas(List<Persona> personas, String archivo) {
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
            try{
                oos.writeObject(personas);
                System.out.println("Personas Aislada");
            } catch (Throwable var6) {
                try{
                    oos.close();
                } catch(Throwable var5) {
                    var6.addSuppressed(var5);
                }
                throw var6;
            }
            oos.close();
        } catch(IOException var7) {
            var7.printStackTrace();
        }
    }


    public void aislar() throws Exception{
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("personaAisalda.dat"));
            ArrayList<RegistroAislar> personasAislar = new ArrayList<>();
            boolean estado = true;
            try {
                for(Persona persona : porLlegada){
                    try{
                        if(persona.getRegistro().getTemperatura() < 38){
                            estado = true;
                            //sanos.add(persona);
                        }else{
                            estado = false;
                        }
                    }catch(Exception e){
                        //aislar.add(persona);
                        RegistroAislar ra = new RegistroAislar(persona.getKitAsignado(), persona.getBarrio());
                        personasAislar.add(ra);
                    }
                }
                oos.writeObject(personasAislar);
            } catch (Throwable var6) {
                try {
                    oos.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }
                throw var6;
            }
            oos.close();
        } catch (IOException var7) {
            var7.printStackTrace();
        }
    }

    public static Queue<Persona> leerPersonas(String archivo) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));

            List var3;
            try {
                List<Persona> personas = (List)ois.readObject();
                var3 = personas;
            } catch (Throwable var5) {
                try {
                    ois.close();
                } catch (Throwable var4) {
                    var5.addSuppressed(var4);
                }

                throw var5;
            }

            ois.close();
            return (Queue<Persona>) var3;
        } catch (ClassNotFoundException | IOException var6) {
            var6.printStackTrace();
            return null;
        }
    }
    public HashMap<Integer, Registro> testear(Persona p){
        HashMap<Integer, Registro> hm = new HashMap<>();
        for(Persona persona : porLlegada){
            Registro registro = new Registro(p.getRegistro().getDni());
            hm.put(p.getKitAsignado(), registro);
        }
        return hm;
    }

    public void estadoTest(){
        ArrayList<Persona> sanos = new ArrayList<>();
        ArrayList<Persona> aislar = new ArrayList<>();
        try(FileWriter writer = new FileWriter("estadoTest.bin")){
            for(Persona p : porLlegada){
                if(p.getRegistro().getTemperatura() < 38){
                    Persona datos = new Persona();
                    datos.setNombre(p.getNombre());
                    datos.setApellido(p.getApellido());
                    datos.setEdad(p.getEdad());
                    datos.getRegistro().setDni(p.getRegistro().getDni());
                    sanos.add(p);
                }else{
                    Persona regAislar = new Persona();
                    regAislar.setKitAsignado(p.getKitAsignado());
                    regAislar.getRegistro().setTemperatura(p.getRegistro().getTemperatura());
                    regAislar.setBarrio(p.getBarrio());
                    aislar.add(p);
                }
            }
            Gson gson = new GsonBuilder().create();
            String jsonSanos = gson.toJson(sanos);
            String jsonAislar = gson.toJson(sanos);
            writer.append(jsonSanos);
            writer.append(jsonAislar);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Integer kitRandom(){
        Random ran = new Random();
        return ran.nextInt(50);
    }
    public class ComparadorDNI {
        public static boolean dniExiste(String dni1, String dni2) {
            return dni1.equals(dni2);
        }
    }

    @Override
    public String toString() {
        return "SSM{" +
                "nombre='" + nombre + '\'' +
                ", porLlegada=" + porLlegada +
                ", cantidadTest=" + cantidadTest +
                '}';
    }
}
