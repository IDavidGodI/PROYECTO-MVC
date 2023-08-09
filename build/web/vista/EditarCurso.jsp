
<%@ page import="modelo.Curso" %>
<%
    Curso selec = (Curso) request.getAttribute("info_curso");
%>
<div class="d-flex justify-content-center bg-light rounded w-50">
    <form method="post" action="EditarCurso" >
        <div class="row g-2 p-2 justify-content-center"> 
            <input type="hidden" name="cod_curso" value="<%= request.getAttribute("cod_curso") %>">
            <div class="col-auto">
              <label for="notaEstudiante" class="visually-hidden">nombre curso:</label>
              <input type="text" name="nombre_curso" class="form-control" id="notaEstudiante" placeholder="Ingrese la nueva nota" value="<%= selec.getNombre() %>">
            </div>
        </div>
        <div class="row g-2 p-2 ">
            <div class="col-auto">
              <label for="notaEstudiante" class="visually-hidden">hora inicio:</label>
              <input type="time" name="hora_i" class="form-control" id="notaEstudiante" placeholder="Ingrese la nueva nota" value="<%= selec.getHora_i()%>">
            </div>
            <div class="col-auto">
              <label for="notaEstudiante" class="visually-hidden">hora fin:</label>
              <input type="time" name="hora_f" class="form-control" id="notaEstudiante" placeholder="Ingrese la nueva nota" value="<%= selec.getHora_f()%>">
            </div>
            <div class="col-auto">
              <button type="submit" class="btn btn-primary">Actualizar</button>  
            </div>
        </div>
        <div class="row g-2 p-2 w-100">
            <jsp:include page="ListaErrores.jsp" />    
        </div>
    </form>   
</div>