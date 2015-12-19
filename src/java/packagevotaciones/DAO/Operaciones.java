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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import packagevotaciones.MODEL.Partidos;
import packagevotaciones.MODEL.Votantes;

/**
 *
 * @author Coconut
 *
 */

 public class Operaciones {

    
     
    public boolean usuario(Connection _conexion, Votantes _user){

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
    /**
     * 
     * @param _conexion
     * @param _nuevoU
     * @return boolean que indica si la inserción se ha realizado correctamente
     * 
     */
    public boolean addVotante(Connection _conexion, Votantes _nuevoU){
                
            String _dni = _nuevoU.getDni();
            String _clave = _nuevoU.getClave();
            int _voto = _nuevoU.getVoto();
            
            boolean flg = false;
        try {    
            PreparedStatement PStm = _conexion.prepareStatement("INSERT INTO votantes VALUES ('"+_dni+"', aes_encrypt('"+_clave+"', '"+_dni+"'), "+_voto+") ;");
//            PStm.setString(1, _dni);
//            PStm.setString(2, _clave);
//            PStm.setInt(3, _voto);
            PStm.executeUpdate();
            flg = true;
        } catch (SQLException ex) {
            ex.getMessage();
            if (_conexion != null){
		try{
                    flg = false;
                    _conexion.rollback();
                }catch(SQLException SQLEx2){
                    SQLEx2.getMessage();}
		}
	}
        
        return flg;
         
        }
        
    public void addPartido(Connection _conexion, Partidos _nuevoP){
        
         
        
        
        
    }
    
    /**
     * 
     * @param _conexion
     * @return ArrayList de objetos Votantes 
     */
    public ArrayList<Votantes> censoElectoral(Connection _conexion){
        ArrayList<Votantes> _censo = new ArrayList();
        
        try {
            Statement st = _conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM votantes");
            
            while(rs.next()){
                
                Votantes _censado = new Votantes(rs.getString("dni"), rs.getInt("voto"));
                _censo.add(_censado);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return _censo;
        
    }
    
    public ArrayList<Partidos> censoPartidos(Connection _conexion){
        ArrayList<Partidos> _partidos = new ArrayList();
        
        try{
            Statement st = _conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM partidos");
            
            while(rs.next()){
                
                Partidos _partido = new Partidos(rs.getString("logo"), rs.getString("nombre"));
                _partidos.add(_partido);
            }
            
            
        }  catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return _partidos;
        
    }
    
}
