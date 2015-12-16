/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagevotaciones.CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import packagevotaciones.DAO.ConexionBBDD;
import packagevotaciones.DAO.Operaciones;
import packagevotaciones.MODEL.Votantes;

/**
 *
 * @author Coconut
 */
public class servletControladorEntrada extends HttpServlet {

    
    private Connection Conexion;
    private ConexionBBDD ConexBD;

       @Override
   public void init() throws ServletException {
       /* Establecemos la conexi�n, si no existe */
            try{
                ConexBD = ConexionBBDD.GetConexion();//ConexDB se cre� en el JspInit(), luego usa aqu�l y no crea objeto.
                Conexion = ConexBD.GetCon();
            }catch(ClassNotFoundException cnfe){  
                }
            catch(SQLException sqle){
            }
      }
   
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        //datos usuario
        String nif = request.getParameter("nifVotante");  
        String pass = request.getParameter("claveVotante");
        
        
//        Blob clave; //tipo blob para almacenar el dato pass a convertir.
//        
//        byte[] byteContent = pass.getBytes(); // tipo byte, instancia que almacena el String
//        clave = Conexion.createBlob();//Where connection is the connection to db object. se crea el obj donde se almacenara el String transformado en binario
//        clave.setBytes(1, byteContent); //almacena en el obj tipo blob la cadena transformada.
        
        if(nif.equals("20D2015") && pass.equals("5102D02")){
            response.sendRedirect("administracion.jsp");
        }
        else{
            Votantes usuario = new Votantes(nif, pass);
            Operaciones op = new Operaciones();

            String value = request.getParameter("btn-index");
            
            ServletContext sc = getServletContext(); //OBJ que devuelve el contexto del servlet.
                RequestDispatcher rd; //OBJ de tipo dispatcher.
                
//aqui se comprueba el usuario y su contraseña.
            if ( op.usuario(Conexion, usuario) ){

                switch(value){

                    case "VOTANTE":
                        out.println(value);
                        rd = sc.getRequestDispatcher("/servletVotante");//redirige al servlet que comprueba si el usuario ha votado.
                        rd.forward(request, response);//pasa al process request del servlet destino los datos que se manejan aqui.
                        break;
                    case "LISTAR CENSO":
                        out.println(value);
                        rd = sc.getRequestDispatcher("/servletCenso");//redirige al servlet que comprueba si el usuario ha votado.
                        rd.forward(request, response);//pasa al process request del servlet destino los datos que se manejan aqui.
                        break;
                    case "CERRAR ESCRUTINIO":
                        out.println(value);
                        rd = sc.getRequestDispatcher("/servletEscrutinio");//redirige al servlet que comprueba si el usuario ha votado.
                        rd.forward(request, response);//pasa al process request del servlet destino los datos que se manejan aqui.
                        break;
                    case "RESULTADOS":
                        out.println(value);
                        rd = sc.getRequestDispatcher("/servletResultados");//redirige al servlet que comprueba si el usuario ha votado.
                        rd.forward(request, response);//pasa al process request del servlet destino los datos que se manejan aqui.
                        break;

                }

            }
            else{
                response.sendRedirect("index.jsp");
            }
        
        }
//            
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet servletControladorEntrada</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet servletControladorEntrada at HEEEEEY holi"+nif+" :: " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        }    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
