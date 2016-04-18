/**
 *
 * @author adolfo
 */
public class IntermediateCode {
    // Atributos
    private String firstDir;
    private String secondDir;
    private String res;
    private String operator;
    private String lenght;
    private String label;
    private String type;
    
    // Atributos verificadores
    private boolean isGlobal;
    private boolean isIfStatement;
    private String bandera;
    
    private IntermediateCode gotoLabel;
    private boolean isDeclaration;

    public IntermediateCode(String firstDir, String secondDir, String operator) {
        this.firstDir = firstDir;
        this.secondDir = secondDir;
        this.operator = operator;
    }

    public IntermediateCode() {}
    
    public String getFirstDir() {
        return firstDir;
    }

    public void setFirstDir(String firstDir) {
        this.firstDir = firstDir;
    }

    public String getSecondDir() {
        return secondDir;
    }

    public void setSecondDir(String secondDir) {
        this.secondDir = secondDir;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getLenght() {
        return lenght;
    }

    public void setLenght(String lenght) {
        this.lenght = lenght;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isGlobal() {
        return isGlobal;
    }

    public void setIsGlobal(boolean isGlobal) {
        this.isGlobal = isGlobal;
    }

    public boolean isIfStatement() {
        return isIfStatement;
    }

    public void setIsIfStatement(boolean isIfStatement) {
        this.isIfStatement = isIfStatement;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    public IntermediateCode getGotoLabel() {
        return gotoLabel;
    }

    public void setGotoLabel(IntermediateCode gotoLabel) {
        this.gotoLabel = gotoLabel;
    }

    public boolean isDeclaration() {
        return isDeclaration;
    }

    public void setIsDeclaration(boolean isDeclaration) {
        this.isDeclaration = isDeclaration;
    }

    @Override
    public String toString() {
        return "\n" + "firstDir=" + firstDir + ", secondDir=" + secondDir + ", res=" + res + ", operator=" + operator + ", label=" + label + "\n";
    }
}
