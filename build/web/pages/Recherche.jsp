<%-- 
    Document   : recherche
    Created on : Oct 24, 2023, 9:00:32 PM
    Author     : akhmim
--%>

<%@page import="service.SalleService"%>
<%@page import="entities.Salle"%>
<%@page import="entities.Machine"%>
<%@page import="service.MachineService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
        <link href="../styles/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="../components/navbar.jsp"/>
        <div class="flex-box app">

            <form action="../RechercheController" method="GET">
                <fieldset class="flex-box">
                    <legend>Informations Machine Par Salle</legend>                 

                    <label for="salle_id">Code de Salle :</label>
                    <select name="salle_id" >
                        <%
                            SalleService ss = new SalleService();
                            for (Salle s : ss.findAll()) {
                        %>
                        <option  value="<%= s.getId()%>"><%= s.getCode()%></option>
                        <% } %>

                    </select>

                    <input type="submit" value="Rechercher" />

                </fieldset>

            </form>
            <fieldset class="flex-box">
                <legend>Liste Machines</legend>
                <table border="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Reference</th>
                            <th>Marque</th>
                            <th>Prix</th>
                            <th>Salle</th>

                        </tr>
                    </thead>
                    <tbody>

                        <%
                            MachineService ms = new MachineService();
                            System.out.println("Machines");
                            int id = -1;
                            System.out.println("Id:" + request.getParameter("salle_id"));

                            if (request.getParameter("salle_id") != null) {
                                System.out.println("Salles");
                                id = Integer.parseInt(request.getParameter("salle_id"));
                                System.out.println(id);

                                for (Machine m : ms.findAll()) {
                                    System.out.println("Machine Id" + m.getId());
                                    System.out.println("Salle Id" + m.getSalle().getId());
                                    if (m.getSalle().getId() == id) {
                        %>
                        <tr>
                            <td><%= m.getId()%></td>
                            <td><%= m.getRef()%></td>
                            <td><%= m.getMarque()%></td>
                            <td><%= m.getPrix()%></td>
                            <td><%= m.getSalle().getCode()%></td>
                        </tr>
                        <%}
                                }
                            }%>


                    </tbody>
                </table>
            </fieldset>
        </div>
    </body>
</html>
