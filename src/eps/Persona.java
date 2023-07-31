package eps;

/**
 *
 * @author Andres
 */
public class Persona {

    private String Cedula;
    private String nombre;
    private String apellido;
    private int estrato;
    private int genero;

    public Persona() {
    }

    public Persona(String Cedula, String nombre, String apellido, int estrato, int genero) {
        this.Cedula = Cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estrato = estrato;
        this.genero = genero;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
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

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Persona{" + "Cedula: " + Cedula + " - Nombre: " + nombre + " - Apellido: " + apellido + " - Estrato: " + estrato + " -  Genero: " + genero + '}';
    }

}
