/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagevotaciones.CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import packagevotaciones.DAO.ConexionBBDD;
import packagevotaciones.DAO.Operaciones;
import packagevotaciones.MODEL.Partidos;
import packagevotaciones.MODEL.Votantes;

/**
 *
 * @author Coconut
 */
public class servletGestion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
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
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
        HttpSession Sesion = request.getSession(false); 
            
        Operaciones op = new Operaciones();
        String value = request.getParameter("alta");
        boolean proceso;    
        
        switch(value){
            
            case "Alta Usuario":
                String nif = request.getParameter("nifVotante");  
                String pass = request.getParameter("claveVotante");

                Votantes usuario = new Votantes(nif, pass);
                
                proceso = op.addVotante(Conexion, usuario);
                Sesion.setAttribute("estadoInsert", proceso);
                
                out.println(usuario);
                response.sendRedirect("administracion.jsp");
                break;
            
            case "Alta Partido":
                
                String logo = request.getParameter("lP");
                String nombre = request.getParameter("nomP");
                
                Partidos partido = new Partidos(logo, nombre);
                
//                proceso = op.añadirPartido(Conexion, partido);
                
                out.println(partido);
                break;
        }
        
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet servletGestion</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println(usuario);
//            out.println("<h1>Servlet servletGestion at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        }
    }

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
