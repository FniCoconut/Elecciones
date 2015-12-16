<%-- 
    Document   : administracion
    Created on : 16-dic-2015, 12:49:15
    Author     : Coconut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h2>Nuevo Votante</h2>
            <form action="servletGestion">
                <label for="nifVotante">NIF</label><input type="text" id="nifVotante" name="nifVotante" required /><br>
                <label for="claveVotante">CLAVE</label><input type="password" id="claveVotante" name="claveVotante" required /><br>
                <input type="submit" value="Alta Usuario" name="alta" />
            </form>
        </div>
        <div>
            <h2>Nuevo Partido</h2>
            <form action="servletGestion">
                <label for="nombrePartido">Nombre Completo del Partido</label>
                <input type="text" id="nombrePartido" name="nomP" /><br>
                
                <label for="logo">Logotipo</label>
                <input type="file" id="logo" name="lP" />
                <br>
                <input type="submit" value="Alta Partido" name="alta" />
            </form>
        </div>
    </body>
</html>
