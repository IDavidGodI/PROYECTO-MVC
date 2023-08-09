<%-- 
    Document   : TablaCursos
    Created on : 5 ago 2023, 13:32:27
    Author     : Lenovo
--%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Curso" %>
<table class="table table-striped text-center">
    <thead>
      <tr class="align-middle table-light  ">
        <th scope="col">CODIGO</th>
        <th scope="col">NOMBRE</th>
        <th scope="col">HORA DE INICIO</th>
        <th scope="col">HORA DE FIN</th>
        <th scope="col">VER</th>
        <th scope="col">ELIMINAR</th>
        <th scope="col">EDITAR</th>

      </tr>
    </thead>
    <tbody>
        <% 
        List<Curso> cursos = (List<Curso>) request.getAttribute("ListaCursos");
        int seleccionado = -1;
        if (request.getAttribute("cod_curso")!=null) seleccionado = (int) request.getAttribute("cod_curso");
        boolean esSeleccionada = false;
        if (cursos != null)
            for (Curso c : cursos) {
                esSeleccionada = c.getCod()==seleccionado;
                if (esSeleccionada) {
                    request.setAttribute("nombre_curso", c.getNombre());
                }
        %>
            <tr class="align-middle <%= esSeleccionada ? "table-info" : "" %>">
                
                <th class="text-center" scope="row" ><%= c.getCod() %></th>
                <td><%= c.getNombre() %></td>
                <td><%= c.getHora_i() %></td>
                <td><%= c.getHora_f() %></td>
                <form action="TablaCursosAc" method="post">
                    <input type="hidden" name="codigo" value="<%= c.getCod() %>">
                    <td class="text-center">
                        <button name="ver" class="btn btn-info" <%= esSeleccionada ? "disabled" : "" %> ><i class="fa fa-eye"></i></button>
                    <td class="text-center">
                        <button name="eliminar" class="btn btn-danger"><i class="fa fa-ban "></i></button>
                    </td>
                    </td>
                    <td class="text-center">
                        <button name="editar" class="btn btn-success"><i class="fa fa-edit"></i></button>
                    </td>
                </form>
            </tr>
        <% } 
        else %> <tr class="align-middle text-center table-secondary" ><td colspan="7"> No tiene cursos en este momento </td></tr>
      
      
    </tbody>
</table>
