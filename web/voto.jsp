<%-- 
    Document   : voto
    Created on : 18-dic-2015, 14:25:00
    Author     : Coconut
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="packagevotaciones.MODEL.Partidos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Elecciones 20-D 2015</h1>
        
        <%
            HttpSession Sesion = request.getSession(false);
            ArrayList<Partidos> partidos = (ArrayList)Sesion.getAttribute("partidos");
            %>
            
            <table>
                <thead>
                    <tr>
                        <td colspan="2">Partido</td>
                        <td>Logotipo</td>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    for (int i=0; i<partidos.size(); i++){
                        %>
                    
                    <tr>
                        <td><input type="radio" name="voto" /></td>
                        <td><%=(partidos.get(i).getNombre()) %></td>
                        <td><img src="<%=(partidos.get(i).getLogo()) %>" alt="partido"/></td>
                    </tr>
                    <%
                       }
                    %> 
                       
                    
                </tbody>
            </table>
            
    </body>
</html>
