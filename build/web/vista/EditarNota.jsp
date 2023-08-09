<div class="d-flex justify-content-center bg-light rounded w-50">
    <form method="post" action="CalificarEstudiante" >
        <div class="row g-2 p-2 "> 

            <input type="hidden" name="cc" value="<%= request.getAttribute("cc_estudiante") %>">
            <div class="col-auto">
              <label for="notaEstudiante" class="visually-hidden">Nota estudiante:</label>
              <input type="text" name="nota_estudiante" class="form-control" id="notaEstudiante" placeholder="Ingrese la nueva nota">
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