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
}
