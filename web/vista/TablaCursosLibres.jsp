<%-- 
    Document   : TablaCursos
    Created on : 5 ago 2023, 13:32:27
    Author     : Lenovo
--%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Curso" %>
<%@ page import="modelo.CursoDAO" %>
<table class="table table-striped text-center">
    <thead>
      <tr class="align-middle table-light  ">
        <th scope="col">CODIGO</th>
        <th scope="col">NOMBRE</th>
        <th scope="col">HORA DE INICIO</th>
        <th scope="col">HORA DE FIN</th>
        <th scope="col">AGREGAR</th>

      </tr>
    </thead>
    <tbody>
        <% 
        CursoDAO cd = new CursoDAO();    
        List<Curso> cursos = cd.getCursos(null);
        if (cursos != null)
            for (Curso c : cursos) {
        %>
            <tr class="align-middle">
                
                <th class="text-center" scope="row" ><%= c.getCod() %></th>
                <td><%= c.getNombre() %></td>
                <td><%= c.getHora_i() %></td>
                <td><%= c.getHora_f() %></td>
                <form action="TablaCursosAc" method="post">
                    <input type="hidden" name="codigo" value="<%= c.getCod() %>">
                    <td class="text-center">
                        <button name="agregar" class="btn btn-success"><i class="fa fa-plus"></i></button>
                    </td>

                </form>
            </tr>
        <% } 
        else %> <tr class="align-middle text-center table-secondary" ><td colspan="7"> No hay cursos disponibles en este momento </td></tr>
      
      
    </tbody>
</table>