<%-- 
    Document   : salles
    Created on : Oct 24, 2023, 9:00:32 PM
    Author     : akhmim
--%>

<%@page import="entities.Salle"%>
<%@page import="service.SalleService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Classes Page</title>
        <link href="../styles/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="../components/navbar.jsp"/>
        <div class="flex-box app">
            <form action="../SalleController" method="GET" >
                <fieldset class="flex-box">

                    <legend>Informations Salles</legend>  
                    <label for="salleId">Code de Salle :</label>
                    <input type="text" name="code" value="" />
                    <input type="submit" value="Ajouter" />
                    <input type="reset" value="Annuler" />

                </fieldset>

            </form>
            <fieldset class="flex-box">
                <legend>Liste Salles</legend>
                <table border="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Code</th>
                            <th>Modifier</th>
                            <th>Supprimer</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            SalleService ss = new SalleService();
                            for (Salle s : ss.findAll()) {
                        %>
                        <tr>
                            <td><%= s.getId()%></td>
                            <td><%= s.getCode()%></td>
                            <td><a href="SalleController?op=update&id=<%=s.getId()%>">Modifier</a></td>
                            <td><a href="SalleController?op=delete&id=<%=s.getId()%>">Supprimer</a></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>

                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </fieldset>
        </div>
    </body>
</html>

