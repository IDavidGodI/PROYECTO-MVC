
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="modelo.Curso" %>
<%@ page import="modelo.CursoDAO" %>
<%@ page import="modelo.Estudiante" %>
<%@ page import="modelo.EstudianteDAO" %>
<!DOCTYPE html>
<%
    
    if(request.getSession().getAttribute("ID")==null) response.sendRedirect("Login.jsp");
    else{
%>
<html>
    <head>
        <title>Inicio</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="Per.css">
        <link rel="icon" type="image/x-icon" href="imagenes/PalomaSentá.png">
    </head>
    <body>
        <%
           CursoDAO cd = new CursoDAO();
           int ID = (int) request.getSession().getAttribute("ID");
           
           request.setAttribute("ListaCursos", cd.getCursos(ID));

        %>
        <jsp:include page="vista/BarraSuperior.jsp"/>
        <div class="container mw-100 p-2">
            <div class="row justify-content-evenly wrap">
              <div class="col-xl-5">
                  <h2 class="fw-bold">SUS CURSOS</h2>
                  <jsp:include page="vista/TablaCursos.jsp"/>
                  <%
                        if(request.getAttribute("info_curso")!=null){
                            
                    %>
                    <div class="d-flex justify-content-center">
                        <jsp:include page="vista/EditarCurso.jsp"/>
                    </div>
                    <%}%>
              </div>
              <div class="col-xl-5">
                  <%
                    if (request.getAttribute("cod_curso")!=null){
                        EstudianteDAO ed = new EstudianteDAO();
                        String codigo = (String) request.getAttribute("cod_curso");
                        request.setAttribute("ListaEstudiantes", ed.getEstudiantes(codigo));
                  %>
                    <h2 class="fw-bold">Estudiantes de <%= request.getAttribute("nombre_curso") %></h2>
                    <jsp:include page="vista/TablaEstudiantes.jsp"/>
                    <%
                        if(request.getAttribute("cc_estudiante")!=null){
                            
                    %>
                    <div class="d-flex justify-content-center">
                        <jsp:include page="vista/EditarNota.jsp"/>
                    </div>
                    <%}%>
                  <%}else{%>
                    <h2 class="text-muted text-center p-5">No se ha seleccionado un curso</h2>
                  <%}%>
              </div>
            </div>
          </div>
              
              
              
        <jsp:include page="vista/BarraInferior.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    </body>
</html>
<%}%>