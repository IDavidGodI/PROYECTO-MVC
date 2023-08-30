<%-- 
    Document   : TablaEstudiantes
    Created on : 5 ago 2023, 13:33:32
    Author     : Lenovo
--%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Curso" %>
<%@ page import="modelo.CursoDAO" %>
<table class="table table-sm table-striped text-center">
    <thead>
      <tr class="align-middle">
        <th scope="col">CEDULA</th>
        <th scope="col">NOMBRE</th>
        <th scope="col">NOTA</th>
        <th scope="col">AGREGAR</th>
      </tr>
    </thead>
    <tbody>
      <% 
        CursoDAO ed = new CursoDAO();
        List<Curso> estudiantes = ed.;
        String seleccionado = null;
        if (request.getAttribute("cc_estudiante")!=null) seleccionado = (String) request.getAttribute("cc_estudiante");
        if (estudiantes != null)
            for (Curso e : estudiantes) { 
        %>
        <tr class="align-middle <%= e.getCc().equals(seleccionado) ? "table-success" : "" %>">
                <th class="text-center" scope="row" > <%= e.getCc() %> </th>
                <td><%= e.getNombre() %> </td>
                <td><%= e.getNota() %></td>
                <form action="TablaEstudiantesAc" method="post">
                    <input type="hidden" name="cc" value="<%= e.getCc() %>">
                    <td class="text-center">
                        <button name="eliminar" class="btn btn-danger"><i class="fa fa-ban"></i></button>
                    </td>
                    <td class="text-center">
                        <button name="editar" class="btn btn-success"><i class="fa fa-edit"></i></button>
                    </td>
                </form>
            </tr>
        <% } 
        else %> <tr class="align-middle text-center table-secondary" ><td colspan="5"> Este curso no tiene estudiantes inscritos </td></tr>
    </tbody>
</table>
