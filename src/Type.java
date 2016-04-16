import java.util.ArrayList;
/**
 *
 * @author GustavoAdolfo
 */
public class Type {

    private boolean isSimple;
    private boolean isStructure;
    private boolean isParam;
    private boolean isArray;
    private int arrayLenght;

    private ArrayList<Symbol> items = new ArrayList();
    
    private String nombreTipo;
    
    public Type(String tipo) {
        this.nombreTipo = tipo;
        this.isSimple = false;
        this.isStructure = false;
        this.isArray = false;
        this.isParam = false;
    }

    public boolean isSimple() {
        return isSimple;
    }

    public void setIsSimple(boolean simple) {
        this.isSimple = simple;
    }

    public boolean isStructure() {
        return isStructure;
    }

    public void setIsStructure(boolean structure) {
        this.isStructure = structure;
    }

    public boolean isArray() {
        return isArray;
    }

    public void setIsArray(boolean array, int lenght) {
        this.isArray = array;
        this.arrayLenght = lenght;
    }

    public void setIsArray(boolean array) {
        this.isArray = array;
    }

    public ArrayList<Symbol> geItems() {
        return items;
    }

    public void setItems(ArrayList<Symbol> items) {
        this.items = items;
    }

    public String getTypeName() {
        String type = nombreTipo;
        
        if(this.isArray()) {
            type = type + "[]";
        } else if(this.isStructure()) {
            type = "struct:" + type;
        }
        
        return type;
    }

    public String getTypeNameExceptStruct() {
        String type = nombreTipo;
        if(this.isArray()) {
            type = type + "[]";
        } else if(this.isStructure()) {
            type = "" + type;
        }
        
        return type;
    }
    
    public void setTypeName(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public boolean isParam() {
        return isParam;
    }

    public void setIsParam(boolean param) {
        this.isParam = param;
    }
    
    public void setArrayLenght(int lenght) {
        this.arrayLenght = lenght;
    }
    
    public String toString() {
        if (isParam) {
            return "Tipo parametro";
        }
        if (isSimple) {
            return "Tipo simple";
        }
        if (isStructure) {
            return "Tipo estructura";
        }
        if (isArray) {
            return "Tipo Array";
        }
        return "No tiene tipo";
    }

    public int getArrayLenght() {
        return arrayLenght;
    }
}
