import java.util.ArrayList;

public class StructTable {

    ArrayList<Structure> table = new ArrayList();

    public StructTable() {}

    public boolean addStructure(String id, Scope scope, ArrayList<Symbol> members) {
        return table.add(new Structure(id, scope, members));
    }

    public boolean addStructure(Structure struct) {
        Structure st = this.getStructure(struct.getId(), struct.getScope());
        if(st == null) {
            return table.add(struct);
        }
        
        return false;
    }

    public Structure getLastStruct() {
        return this.table.get(table.size() - 1);
    }

    public Structure getStructure(String id, Scope ambit) {
        Scope local_scope = ambit;

        while(local_scope != null) {
            ArrayList<Structure> list = getAllStructureInScope(local_scope);

            for(int i = 0; i < list.size(); i++) {
                String name = list.get(i).getId();
                if(name.equals(id)) {
                    return list.get(i);
                }
            }
            
            local_scope = local_scope.getAnterior();
        }
        
        return null;
    }

    public ArrayList<Structure> getAllStructureInScope(Scope ambit) {
        ArrayList<Structure> list = new ArrayList();

        for(Structure a : this.table) {
            if(a.getScope().getName() == ambit.getName()) {
                list.add(a);
            }
        }
        
        return list;
    }

    public String[][] getData() {
        String[][] a = new String[this.table.size()][3];
        for(int i = 0; i < a.length; i++) {
            String[] b = this.table.get(i).getData();
            for (int j = 0; j < 3; j++) {
                a[i][j]= b[j];                
            }
        }
        
        return a;
    }

    public String[][] getDefaultData() {
        String[][] a = new String[1][3];
        for (int i = 0; i < 3; i++) {
            a[0][i] = new String();
        }
    
        return a;
    }

    public static String[] getColumNames() {
        String columNames[] = {"Struct name", "Scope", "Members"};
        return columNames;
    }

    public void printData() {
        for (Structure s: table) {
            System.out.println(s);
        }
    }
    
    public String toString() {
        String temp  = new String();
        for(Structure a: this.table) {
            temp += a.toString() + "\n";
        }
        
        return temp;
    }
}