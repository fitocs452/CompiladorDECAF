import java.util.ArrayList;

public class Method {

    private ArrayList<Symbol> parameters = new ArrayList<Symbol>();
    private Type ret;
    private String name;
    
    public Method(String name, Type ret, ArrayList<Symbol> parameters){
        this.parameters = parameters;
        this.ret = ret;
        this.name = name;
    }

    public String getMethodSignature(){
        String retorno = name+"(";
        if(parameters.size()>0){
            retorno+=parameters.get(0).getType().getTypeName()+",";
            for(int i = 1;i<this.parameters.size(); i++){
                Symbol a  = parameters.get(i);
                retorno+=""+a.getType().getTypeName()+",";
            }
            retorno = retorno.substring(0, retorno.length()-1);
        }
        retorno+=")";
        return retorno;
    }

    public String[] getData() {
        String[] a = new String[4];
        a[0] = this.ret.getTypeName();
        a[1] = this.name+"";
        a[2] = this.parameters.toString();
        a[3] = this.getMethodSignature();
        return a;
    }

    public String toString(){
        String temp  = "";
        temp += "\t"+this.getMethodSignature();
        return temp;
    }

    public ArrayList<Symbol> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Symbol> parameters) {
        this.parameters = parameters;
    }

    public Type getRet() {
        return ret;
    }

    public void setRet(Type ret) {
        this.ret = ret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}