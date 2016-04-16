import java.util.ArrayList;

public class Structure {
    private ArrayList<Symbol> members = new ArrayList();
    private Scope scope;
    private String id;

    public Structure(){
        this.id = "";
        scope = null;
    }

    public Structure(String id, Scope scope, ArrayList<Symbol> members){
        this.id = id;
        this.scope = scope;
        this.members = members;
    }

    public ArrayList<Symbol> getMembers() {
        return members;
    }

    public Scope getScope() {
        return scope;
    }

    public String getId() {
        return id;
    }

    public Type getType() {
        Type type = new Type(this.id);
        type.setItems(members);
        type.setIsStructure(true);
        
        return type;
    }

    public String[] getData() {
        String[] a = new String[3];
        a[0] = this.id;
        a[1] = this.scope.getName() + "";
        a[2] = this.members.toString();
        
        return a;
    }

    public String toString() {
        String temp = "";
        temp += "\t" + id + "\n";
        for(Symbol a : this.members) {
            temp += "\t * " + a.getType().getTypeName() + " " + a.getId() + "\n";
        }
        
        return temp;
    }
}
