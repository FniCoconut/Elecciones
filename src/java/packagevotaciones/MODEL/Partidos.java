/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagevotaciones.MODEL;

/**
 *
 * @author Coconut
 */
public class Partidos {

    private String logo;
    private String nombre;
    private int votos;

    public Partidos(String logo, String nombre, int votos) {
        this.logo = logo;
        this.nombre = nombre;
        this.votos = votos;
    }

    public Partidos(String logo, String nombre) {
        this.logo = logo;
        this.nombre = nombre;
        this.votos = 0;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }
    
    
    
    
}
