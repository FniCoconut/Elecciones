<%-- 
    Document   : index
    Created on : 01-dic-2015, 13:04:12
    Author     : Coconut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="VIEW/CSS/style.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
        <header class="cabecera-elecciones">
            <h2>Elecciones Generales 20-D</h2>
        </header>
        <div class="form-votante">
            <form action="servletControladorEntrada">
            
                <label for="nifVotante">NIF</label><input type="text" id="nifVotante" name="nifVotante" />
                <label for="claveVotante">CLAVE</label><input type="password" id="claveVotante" name="claveVotante" />
                <br/>

                <input type="submit" value="VOTANTE" name="btn-index"/>
                <input type="submit" value="LISTAR CENSO" name="btn-index"/>
                <input type="submit" value="CERRAR ESCRUTINIO" name="btn-index"/>
                <input type="submit" value="RESULTADOS" name="btn-index"/>

            </form>
        </div>
    </body>
</html>
