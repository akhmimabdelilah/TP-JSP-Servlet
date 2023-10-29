<%-- 
    Document   : machines
    Created on : Oct 24, 2023, 9:00:32 PM
    Author     : akhmim
--%>

<%@page import="entities.Machine"%>
<%@page import="service.MachineService"%>
<%@page import="entities.Salle"%>
<%@page import="service.SalleService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Machines Page</title>
        <link href="../styles/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="../components/navbar.jsp"/>
        <div class="flex-box app">

            <form action="../MachineController" method="GET">

                <fieldset class="flex-box" style="flex-direction: column;">

                    <legend>Informations Machines</legend>  
                    <div class="flex-box">
                        <label for="ref">Reference :</label>
                        <input type="text" name="ref" value="" />

                        <label for="marque">Marque :</label>
                        <input type="text" name="marque" value="" />

                        <label for="prix">Prix :</label>
                        <input type="text" name="prix" value="" />

                        <label for="salleId">Salle :</label>
                        <!--<input type="text" name="salleId" value="" />-->

                        <select name="salleId" >
                            <%
                                SalleService ss = new SalleService();
                                for (Salle s : ss.findAll()) {
                            %>
                            <option  value="<%= s.getId()%>"><%= s.getId()%></option>
                            <% } %>

                        </select>
                    </div>

                    <div class="flex-box" >
                        <input type="submit" value="Ajouter" />
                        <input type="reset" value="Annuler" />
                    </div>

                </fieldset>

            </form>
            <fieldset class="flex-box" >
                <legend>Liste Machines</legend>
                <table border="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Reference</th>
                            <th>Marque</th>
                            <th>Prix</th>
                            <th>Salle</th>
                            <th>Modifier</th>
                            <th>Supprimer</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            MachineService ms = new MachineService();
                            for (Machine m : ms.findAll()) {

                        %>
                        <tr>
                            <td><%= m.getId()%></td>
                            <td><%= m.getRef()%></td>
                            <td><%= m.getMarque()%></td>
                            <td><%= m.getPrix()%></td>
                            <td><%= m.getSalle().getCode()%></td>

                            <td><a href="MachineController?op=update&id=<%= m.getId()%>&ref=<%= request.getParameter("ref")%>&marque=<%= request.getParameter("marque")%>&prix=<%= request.getParameter("prix")%>&salle=<%= request.getParameter("salleId")%>">Modifier</a></td>
                            <td><a href="MachineController?op=delete&id=<%=m.getId()%>">Delete</a></td>

                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
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
