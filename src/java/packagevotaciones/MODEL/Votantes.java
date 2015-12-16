/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagevotaciones.MODEL;

import java.sql.Blob;

/**
 *
 * @author Coconut
 */
public class Votantes {
    
    private String dni;
    private String clave;
//    private Blob clave;
    private int voto; //0 o 1.

    public Votantes(String dni, String clave, int voto) {
        this.dni = dni;
        this.clave = clave;
        this.voto = voto;
    }
    
    public Votantes(String dni, String clave){
        this.dni = dni;
        this.clave = clave;
        this.voto = 0;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }
    
    
    
}
