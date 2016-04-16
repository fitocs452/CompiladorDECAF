/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GustavoAdolfo
 */
public class MensajeLog {
    private String mensaje;
    private boolean isError;
    
    public MensajeLog(String mensaje, boolean isError) {
        this.mensaje = mensaje;
        this.isError = isError;
    }
    
    public MensajeLog(String mensaje) {
        this.mensaje = mensaje;
        this.isError = false;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }
}
