<%-- 
    Document   : machines
    Created on : 24 oct. 2023, 17:34:47
    Author     : YASSINE
--%>

<%@page import="entities.Machine"%>
<%@page import="services.MachineService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="MachineController">
            <fieldset>
                <legend> Informations Machine</legend>
                <table border="0">
                    
                      
                        <tr>
                            <td>Reférence :</td>
                            <td><input type="text" name="ref" value="" /></td>
                        </tr>
                        <tr>
                            <td>Marque :</td>
                            <td><input type="text" name="marque" value="" /></td>
                        </tr>
                        <tr>
                            <td>Prix :</td>
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
                    MachineService ms= new MachineService();
                    for(Machine m :ms.findAll()){  
                        
                    %>
                    <tr>
                        
                        <td><%=m.getId()  %></td>
                        <td><%=m.getRef() %></td>
                         <td><%=m.getMarque() %></td>
                        <td><%=m.getPrix()%></td>
                        <td><a href="MachineController?op=delete&id=<%=m.getId()%>">supprimer</a></td>
                        <td><a href="MachineController?op=update&id=<%=m.getId()%>">modifier</a></td>

                    </tr>
                    <%
                    }
                    %>
                </tbody>
            </table>

        </fieldset>
    </body>
</html>
