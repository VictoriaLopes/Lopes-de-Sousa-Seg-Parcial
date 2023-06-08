import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SSM ssm = new SSM("HPC");
        ssm.setCantidadTest(50);

        Persona p1 = new Persona("Jonhatan", "Ken", 50, "LA Heras", "ewfwef", new Registro("422825456"));
        Persona p2 = new Persona("Marta", "Ken", 45, "LALA", "dadadas", new Registro("5254958"));
        Persona p3 = new Persona("Jor", "El", 20, "adsdsa", "fsdsfd", new Registro("42282580"));
        p1.setKitAsignado(ssm.kitRandom());
        p2.setKitAsignado(ssm.kitRandom());
        p3.setKitAsignado(ssm.kitRandom());

        ssm.agregarPersona(p1);
        ssm.agregarPersona(p2);
        ssm.agregarPersona(p3);
        System.out.println(ssm);

        ssm.porLlegada.add(p1);
        ssm.porLlegada.add(p2);
        ssm.porLlegada.add(p3);

    }
}