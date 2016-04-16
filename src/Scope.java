import java.util.ArrayList;
/**
 *
 * @author GustavoAdolfo
 */
public class Scope {

    private int name; // Número del ámbito actual
    private Scope anterior; // Ámbito padre
    private ArrayList<Scope> siguientes; // Ámbitos hijos o que pertenecen al ámbito
    private int contHijos = 0; // Contador de estructuras, funciones, entre otros que son hijos
    
    public static int ambitoActual = 0; // Es un static para que no se pierda el correlativo

    // Se inicializan las variables
    public Scope() {
        name = (ambitoActual++);
        this.siguientes  = new ArrayList();
        this.anterior = null;
    }

    public Scope(Scope anterior){
        name = (ambitoActual++);
        this.anterior = anterior;
        //Al terminar el árbol se agrega al anterior del nuevo
        anterior.addScopeChild(this);
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Scope getAnterior() {
        return anterior;
    }

    public void setAnterior(Scope anterior) {
        this.anterior = anterior;
    }

    public void addScopeChild(Scope hijo) {
        this.siguientes.add(hijo);
    }

    public Scope getScopeChild() {
        if(contHijos < this.siguientes.size()) {
            return this.siguientes.get(contHijos++);
        }
        return null;
    }

    public ArrayList<Scope> getSiguiente() {
        return siguientes;
    }
    
    public void setSiguiente(ArrayList<Scope> siguiente) {
        this.siguientes = siguiente;
    }

    public String toString() {
        return "Número scope: " + this.name;
    }
}
