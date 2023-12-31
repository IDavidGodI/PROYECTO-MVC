
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<% 
    request.getSession().invalidate();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="icon" type="image/x-icon" href="imagenes/PalomaSentá.png">
    </head>
    <body
        style="
        background: url('fondo1.jpg') no-repeat center center fixed;
        height: 100vh;
        background-size: cover;
        overflow:hidden;"
    >
        
        <div class="container h-100">
            <div class="row h-100 justify-content-center align-items-center ">
              <form method="post" action="IngresoProfesor" class="col-12 bg-light rounded p-1">
                <div class="form-group m-4">
                  <label for="ccProfesor">Cedula de profesor</label>
                  <input type="text" name="cc_profesor" class="form-control" id="ccProfesor" placeholder="CC PROFESOR">
                </div>
                  <div class="d-grid gap-2 m-4">
                    <button type="submit" class="btn btn-primary">Ingresar</button>  
                  </div>
                <jsp:include page="vista/ListaErrores.jsp" />
              </form>   
            </div>
        </div>
    </body>
</html>
