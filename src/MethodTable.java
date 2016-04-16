import java.util.ArrayList;

public class MethodTable {

    ArrayList<Method> methodTable = new ArrayList();

    public MethodTable(){}

    public boolean addMethod(String name, Type ret, ArrayList<Symbol> parameters){
        Method met = new Method(name, ret, parameters);
        //buscar si ya existe esa firma en algún lado
        for(Method a : this.methodTable){
            if(a.getMethodSignature().equals(met.getMethodSignature())){
                //su firma es igual...
                return false;
            }
        }
        this.methodTable.add(met);
        return true;
    }

    public boolean addMethod(Method met){
        //buscar si ya existe esa firma en algún lado
        for(Method a : this.methodTable){
            if(a.getMethodSignature().compareTo(met.getMethodSignature())==0){
                //su firma es igual...
                return false;
            }
        }
        this.methodTable.add(met);
        return true;
    }

    public Method getMethod(String signature){
        //buscar si ya existe esa firma en algún lado
        for(Method a : this.methodTable){
            if(a.getMethodSignature().compareTo(signature)==0){
                //su firma es igual...
                return a;
            }
        }
        return null;
    }

    public String[][] getData(){
        //"Return", "Name", "Parameters"
        String[][] a = new String[this.methodTable.size()][4];
        for(int i = 0; i < a.length; i++) {
            String[] b = this.methodTable.get(i).getData();
            for (int j = 0; j < 4; j++) {
                a[i][j] = b[j];
            }
        }
        
        return a;
    }

    public String[][] getDefaultData() {
        String[][] a = new String[1][4];
        for (int i = 0; i < 4; i++) {
            a[0][i] = new String();
        }

        return a;
    }

    public void printData() {
        for (Method m: this.methodTable) {
            System.out.println("Método " + m);
            System.out.println("Parametros: ");
            for (Symbol s: m.getParameters()) {
                System.out.println(s);
            }
        }
    }
    
    public static String[] getColumNames() {
        String columNames[] = {"Return", "Name", "Parameters", "Signature"};
        
        return columNames;
    }

    public String toString() {
        String temp  = "";
        for(Method a: this.methodTable) {
            temp += a.toString() + "\n";
        }
        
        return temp;
    }
    
    public ArrayList<Method> getAllMethods() {
        return this.methodTable;
    }
}
