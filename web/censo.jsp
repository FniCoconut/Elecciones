<%-- 
    Document   : censo
    Created on : 18-dic-2015, 13:32:35
    Author     : Coconut
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="packagevotaciones.MODEL.Votantes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Censo electoral Elecciones 20-D 2015</h1>
        
        <%
            HttpSession Sesion = request.getSession(false);
            ArrayList<Votantes> censo = (ArrayList)Sesion.getAttribute("censo");
            String vota = "";
            %>
            
            <table>
                <thead>
                    <tr>
                        <td>Ciudadano</td>
                        <td>Vota</td>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    for (int i=0; i<censo.size(); i++){
                        if( 0 == censo.get(i).getVoto() ){
                        vota = "no";}
                        else{
                        vota = "si";
                        }
                        %>
                    
                    <tr>
                        <td><%=(censo.get(i).getDni()) %></td>
                        <td><%=vota %></td>
                    </tr>
                    <%
                       }
                    %> 
                       
                    
                </tbody>
            </table>
            
    </body>
</html>
