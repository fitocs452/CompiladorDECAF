import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author adolfo
 */
public class IntermediateCodeTable {
    private ArrayList<IntermediateCode> tableCodes = new ArrayList();
    private TablesGenerator tablas;

    public IntermediateCodeTable(TablesGenerator tablas) {
        this.tablas = tablas;
    }

    public void addCodigo (IntermediateCode codigo) {
        this.tableCodes.add(codigo);
    }

    public ArrayList<IntermediateCode> getTableCodes() {
        return tableCodes;
    }

    public void setTableCodes(ArrayList<IntermediateCode> tableCodes) {
        this.tableCodes = tableCodes;
    }
    
    public IntermediateCode searchCodeGlobal(String eval){        
        for (IntermediateCode ic: tableCodes) {
            String label = ic.getLabel().substring(0, ic.getLabel().indexOf("_"));
            if (ic.isGlobal()) {
                if (label.equals(eval)) {
                    return ic;
                }
            }
        }
        
        return null;
    }
    
    public Symbol findSymbolInScopes(String id, Scope actual) {
        while (actual != null) {
            for (Symbol s: this.tablas.getTablaSimbolos().getAllSymbolInScope(actual)) {
                if (s.getId().equals(id)) {
                    return s;
                }
            }
            actual = actual.getAnterior();
        }
        
        return null;
    }
    
    public Symbol findSymbolInGlobalScope(String id, Scope scope) {
        Symbol simbolo = this.findSymbolInScopes(id, scope);
        if (simbolo == null) {
            return null;
        }
        
        if (simbolo.getScope().getName() == 0) {
            return simbolo;
        }
        return null;
    }
    
    @Override
    public String toString() {
        String returnString = "";
        for (int i = 0;i<this.tableCodes.size();i++){
            String etiqueta = tableCodes.get(i).getLabel();
            String dir1 = tableCodes.get(i).getFirstDir();
            String dir2 = tableCodes.get(i).getSecondDir();
            String op = tableCodes.get(i).getOperator();
            String res = tableCodes.get(i).getRes();
            boolean global = tableCodes.get(i).isGlobal();
            boolean stIF = tableCodes.get(i).isIfStatement();
            String bandera = tableCodes.get(i).getBandera();
            IntermediateCode gotoL = tableCodes.get(i).getGotoLabel();
            boolean declaration = tableCodes.get(i).isDeclaration();
            if (etiqueta != null && global == false && declaration == false){
                returnString += etiqueta + "\n";
            }
            if (dir1 != null && dir2 != null && op != null && res != null && !stIF){
                returnString += res +" = "+ dir1 +" "+ op +" "+ dir2+"\n";
            }
            if (dir1 != null && dir2 == null && op != null && res != null){
                returnString += res +" "+ op +" "+ dir1+ "\n";
            }
            if (global == true){
                returnString += ".global " + etiqueta +"\n";
               // returnString += etiqueta +": word 0" + "\n";
            }
            if (stIF){
                returnString += res +" "+ dir1+" " + op +" "+ dir2 + "\n";
            }
            if (dir1 == null && op != null && dir2 != null){
                returnString += op +" "+ dir2 + "\n";
            }   
        }
       return returnString;
    }
}
