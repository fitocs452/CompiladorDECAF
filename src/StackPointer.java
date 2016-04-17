/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adolfo
 */
public class StackPointer {
    private int pos;
    private String id;
    private String tipo;
    private String valor;
    
    public static int globalPos = 0;

    public StackPointer(int pos, String id, String tipo, String valor) {
        this.pos = globalPos;
        globalPos += pos;
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
    }

    public StackPointer(int pos, String id, String tipo) {
        this.pos = globalPos;
        globalPos += pos;
        this.id = id;
        this.tipo = tipo;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
