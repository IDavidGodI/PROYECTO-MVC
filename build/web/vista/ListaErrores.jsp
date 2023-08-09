<%-- 
    Document   : ListaErrores
    Created on : 5 ago 2023, 10:45:16
    Author     : Lenovo
--%>

<%@ page import="java.util.List" %>
<%@ page import="vista.Formularios" %>

<ul class="list-group" style="list-style-type: none;">
    <% 
        List<String> errores = (List<String>) request.getAttribute(Formularios.LISTA_ERRORES);
        if (errores != null)
            for (String error : errores) { 
    %>
                <li>
                    <p class="list-group-item list-group-item-danger"><%= error %></p>
                </li>
        <% } %>
</ul>