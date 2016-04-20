/**
 *
 * @author adolfo
 */
public class GlobalStackPointer {
    private int pos;
    private String id;
    private String tipo;
    
    public static int staticPos = 0;
   
    public GlobalStackPointer(int pos, String id, String tipo) {
        this.pos = GlobalStackPointer.staticPos;

        GlobalStackPointer.staticPos = this.pos + pos;
        
        this.tipo = tipo;
        this.id = id;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "GSP{" + "pos=" + pos + ", id=" + id + ", tipo=" + tipo + '}';
    }
    
}
