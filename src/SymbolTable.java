import java.util.ArrayList;
/**
 *
 * @author GustavoAdolfo
 */
public class SymbolTable {

    ArrayList<Symbol> table = new ArrayList();

    
    public SymbolTable() {}
    
    /**
     * 
     * @param id
     * @param ambitoActual
     * @return 
     */
    public boolean existSymbolInScope(String id, Scope ambitoActual) {

        ArrayList<Symbol> list = this.getAllSymbolInScope(ambitoActual);
        for(int i = 0; i < list.size(); i++) {
            String name = list.get(i).getId();
            if(name.equals(id)) {
                return true;
            }
        }
        
        return false;
    }

    /**
     * 
     * @param type_name
     * @param ambit
     * @return 
     */
    public boolean existTypeInScope(String type_name, Scope ambit) {

        ArrayList<Symbol> list = this.getAllSymbolInScope(ambit);
        for(int i = 0; i < list.size(); i++) {
            String name = list.get(i).getType().getTypeName();
            if(name.equals(type_name)) {
                return true;
            }
        }
        
        return false;
    }

    /**
     * Devuelve todos los símbolos que pertenecen al ámbito
     *
     * @param ambito
     * @return 
     */
    public ArrayList<Symbol> getAllSymbolInScope(Scope ambito) {
        ArrayList<Symbol> simbolos = new ArrayList();

        for(Symbol simbolo : this.table) {
            if(simbolo.getScope().getName() == ambito.getName()) {
                simbolos.add(simbolo);
            }
        }
        
        return simbolos;
    }

    /**
     * Devuelve el símbolo de un ámbito
     * 
     * @param id
     * @param ambito
     * @return 
     */
    public Symbol getSymbol(String id, Scope ambito) {
        Scope ambitoActual = ambito;

        while(ambitoActual != null){
            ArrayList<Symbol> list = getAllSymbolInScope(ambitoActual);

            for(int i = 0; i < list.size(); i++) {
                String name = list.get(i).getId();
                if(name.equals(id)) {
                    return list.get(i);
                }
            }
            ambitoActual = ambitoActual.getAnterior();
        }
        
        return null;
    }

    /**
     * 
     * @param id
     * @param ambito
     * @return 
     */
    public boolean existTypeStruct(String id, Scope ambito) {
        Scope ambitoActual = ambito;

        while(ambitoActual != null) {
            ArrayList<Symbol> list = getAllSymbolInScope(ambitoActual);

            for(int i = 0; i < list.size(); i++) {
                String type_name = list.get(i).getType().getTypeName();
                boolean isStruct = list.get(i).getType().isStructure();
                
                if(type_name.equals("struct:" + id) && isStruct) {
                    return true;
                }
            }
            ambitoActual = ambitoActual.getAnterior();
        }
        
        return false;
    }

    /**
     * Obtener el tipo de estructura
     * 
     * @param id
     * @param ambit
     * @return 
     */
    public Type getTypeStruct(String id, Scope ambit) {
        Scope ambitoActual = ambit;

        while(ambitoActual != null) {
            ArrayList<Symbol> simbolosArray = getAllSymbolInScope(ambitoActual);

            for(int i = 0; i < simbolosArray.size(); i++) {
                String type_name = simbolosArray.get(i).getType().getTypeName();
                boolean isStruct = simbolosArray.get(i).getType().isStructure();
                
                if(type_name.equals("struct:" + id) && isStruct) {
                    return simbolosArray.get(i).getType();
                }
            }
            ambitoActual = ambitoActual.getAnterior();
        }
        
        return null;
    }

    /**
     * Obtener los datos de la tabla en forma de una matriz,
     * del tamaño de la tabla
     * 
     * @return String[][]
     */
    public String[][] getData() {
        String[][] a = new String[this.table.size()][8];
        for(int i = 0; i < a.length; i++) {
            String[] b = this.table.get(i).getData();
            for (int j = 0; j < 8; j++) {
                a[i][j] = b[j];
            }
        }
        
        return a;
    }

    /**
     * Obtener una matriz de String que por default está vacía
     * 
     * @return 
     */
    public String[][] getDefaultData() {
        String[][] tabla = new String[1][8];
        for (int i = 0; i < 8; i++) {
            tabla[0][i] = new String();
        }
        
        return tabla;
    }

    public String[] getColumNames() {
        String columNames[] = {
            "id",
            "Scope",
            "Type",
            "Simple",
            "Structure",
            "Param",
            "Array",
            "Items"
        };
        
        return columNames;
    }

    public void printData() {
        // Simbolos en tabla
        System.out.println("Imprimir datos de tabla, la cantidad de simbolos son: " + table.size());
        for (Symbol s: this.table) {
            System.out.println(s);
        }
    }
    // Agregar símbolo a la tabla
    public boolean addSymbol(Symbol symbol, Scope scope) {
        ArrayList<Symbol> simbolosInScope = getAllSymbolInScope(scope);
        
        for (Symbol s: simbolosInScope) {
            if (s.getId().equals(symbol.getId())) {
                System.out.println("Si estaba declarado");
                return false;
            }
        }
        
        return table.add(symbol);
    }

    // Agregar todos los símbolos
    public boolean addAllSymbol(ArrayList<Symbol> symbol) {
        return table.addAll(symbol);
    }
}
