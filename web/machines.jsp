<%-- 
    Document   : machines
    Created on : Oct 24, 2023, 9:00:32 PM
    Author     : brigh
--%>

<%@page import="entities.Machine"%>
<%@page import="service.MachineService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestionnaire des Machines</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Gestionnaire des Machines</h1>
        <form action="MachineController" method="POST">
            <fieldset>
                <legend> Informations Machine</legend>
                <table border="0">


                    <tr>
                        <td>Reférence:</td>
                        <td><input type="text" name="ref" value="" /></td>
                    </tr>
                    <tr>
                        <td>Marque:</td>
                        <td><input type="text" name="marque" value="" /></td>
                    </tr>
                    <tr>
                        <td>Prix:</td>
                        <td><input type="text" name="prix" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Ajouter" /><input type="reset" value="Annuler" /></td>
                        <td></td>
                    </tr>

                </table>

            </fieldset>
        </form>

        <fieldset>               
            <legend> Informations Machine</legend>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Référence</th>
                        <th>Marque</th>
                        <th>Prix</th>
                        <th>Supprimer</th>
                        <th>Modifier</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        MachineService ms = new MachineService();
                        for (Machine m : ms.findAll()) {

                    %>
                    <tr>

                        <td><%=m.getId()%></td>
                        <td><%=m.getRef()%></td>
                        <td><%=m.getMarque()%></td>
                        <td><%=m.getPrix()%></td>
                        <td><a href="MachineController?op=delete&id=<%=m.getId()%>">Supprimer</a></td>
                        <td><a href="MachineController?op=update&id=<%=m.getId()%>">Modifier</a></td>

                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>

        </fieldset>
    </body>
</html>
