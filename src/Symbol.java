/**
 *
 * @author GustavoAdolfo
 */
public class Symbol {

    private String id;
    private Scope  ambito;
    private Type   tipoDato;

    public Symbol(){
        this.id = new String();
    }

    public Symbol(String id, Type tipoDato, Scope ambito){
        this.id = id;
        this.ambito = ambito;
        this.tipoDato = tipoDato;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Scope getScope() {
        return ambito;
    }

    public void setScope(Scope ambito) {
        this.ambito = ambito;
    }

    public Type getType() {
        return tipoDato;
    }

    public void setType(Type tipoDato) {
        this.tipoDato = tipoDato;
    }

    public String[] getData() {
        String[] a = new String[8];
        a[0] = this.id;
        a[1] = this.ambito.getName() + "";
        a[2] = this.getType().getTypeName();
        a[3] = this.getType().isSimple()+ "";
        a[4] = this.getType().isStructure()+ "";
        a[5] = this.getType().isParam()+ "";
        a[6] = this.getType().isArray()+ "";
        a[7] = this.getType().geItems().toString();
        
        return a;
    }

    public String toString(){
        String temp = "";
        temp += id + ": " + tipoDato.getTypeName() + "scope: " + this.ambito.getName();
        
        return temp;
    }
}
