package eps;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

/**
 *
 * @author Andres
 */
public class Eps {

    static Map<String, Persona> personas;

    public Eps() {
        personas = new Hashtable<>();
    }

    public Map<String, Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Map<String, Persona> personas) {
        this.personas = personas;
    }

    //Metodo agregar un nuevo objeto persona
    public void Agregar(Persona persona) {
        personas.put(persona.getCedula(), persona);
    }

    //Metodo consultar un objeto Persona por cedula
    public Persona Consultar(String cedula) {
        return personas.get(cedula);
    }

    //Metodo buscar y retornar el objeto 
    public ArrayList<Persona> BucarApellido(String apellido) {
        Iterator it = personas.keySet().iterator();
        ArrayList<Persona> p = new ArrayList<>();
        while (it.hasNext()) {
            String key = (String) it.next();
            Persona per = personas.get(key);
            if (per.getApellido().equals(apellido)) {
                p.add(per);
            }

        }
        return p;
    }

    //Metodo retorna la cantidad de mujeres de un estrato en especifico
    public int EstratoMujeres(Integer estrato) {
        int cantidad = 0;
        Iterator it = personas.keySet().iterator();
        ArrayList<Persona> p = new ArrayList<>();
        Persona per = new Persona();
        while (it.hasNext()) {
            String key = (String) it.next();
            per = personas.get(key);
            p.add(per);

            for (Persona p1 : p) {
                if (per.getGenero() == 1 && per.getEstrato() == estrato) {
                    cantidad++;
                    break;
                }
            }
        }

        return cantidad;
    }

    //Metodo retornar el objeto que representa la primera persona de dicho estrato que fue agregada al programa
    public void Primera(int estrato, Map<String, Persona> persona) {
        Persona primera = null;
        for (Map.Entry<String, Persona> entry : persona.entrySet()) {
            if (entry.getValue().getEstrato() == estrato) {
                primera = entry.getValue();
                break;
            }
        }
        System.out.println(primera);
    }

    //Metodo  retornar el objeto que representa la persona del mismo estrato que fue agregada después
    public void buscar(String cedula, Map<String, Persona> persona) {
        int estrato = -1;
        Persona siguienteP = null;
        for (Map.Entry<String, Persona> entry : persona.entrySet()) {
            if (estrato != -1) {
                if (entry.getValue().getEstrato() == estrato) {
                    siguienteP = entry.getValue();
                    break;
                }
                continue;
            }
            if (entry.getValue().getCedula().equals(cedula)) {
                estrato = entry.getValue().getEstrato();
            }

        }
        System.out.println(siguienteP);
    }

    public static void main(String[] args) {

        Eps eps = new Eps();
        eps.Agregar(new Persona("1234", "Andres", "Perez", 1, 2));
        eps.Agregar(new Persona("4321", "Pedro", "Barreto", 3, 2));
        eps.Agregar(new Persona("3241", "Maria", "Vargas", 2, 1));
        eps.Agregar(new Persona("4556", "Camila", "Baron", 2, 1));
        eps.Agregar(new Persona("2434", "Fernanda", "Corso", 2, 1));
        eps.Agregar(new Persona("3433", "Andrea", "Rincon", 3, 1));

        System.out.println(eps.Consultar("4321"));
        System.out.println(eps.BucarApellido("Vargas"));
        System.out.println("Cantidad de mujeres: " + eps.EstratoMujeres(2));
        eps.Primera(3, personas);
        eps.buscar("4556", personas);

       

    }

}
