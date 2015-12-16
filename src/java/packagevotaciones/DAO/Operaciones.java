/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagevotaciones.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import packagevotaciones.MODEL.Votantes;

/**
 *
 * @author Coconut
 *
 */

 public class Operaciones {

    
     
    public boolean usuario(Connection _conexion, Votantes _user){

        String _clave = _user.getClave();
        String _dni = _user.getDni();
        boolean bnd = false;
        Votantes userBD;
                        
        try {
            
            PreparedStatement PStm = _conexion.prepareStatement("SELECT aes_decrypt(clave, dni) as clave, dni FROM votantes WHERE dni = ? ;");
            PStm.setString(1, _dni);
//            PStm.setString(2, clave);
            ResultSet rs = PStm.executeQuery();
            
            while(rs.next()){
                String claveBD = rs.getString("clave");//recogemos el dato binario de la bbdd
                String dniBD = rs.getString("dni");
                
                userBD = new Votantes(dniBD, claveBD);

                bnd = (userBD.getClave()).equals(_user.getClave()); // si coinciden true
            }
            
        }catch(SQLException SQLE){
                    SQLE.getMessage();
            }        
        
        return bnd;
        
    }
    
    public void elimiarVotante(){
        
    }
    
    public void eliminarPartido(){
        
    }
    
    public void añadirVotante(Connection _conexion, Votantes _nuevoU){
        
    }
    
    public void añadirPartido(){
        
    }
    
    public void censoElectoral(Connection _conexion){
        
        
    }
    
}
