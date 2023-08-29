<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <title>Autenticación de código</title>
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
    <%
        String estadoCodigo = (String) request.getAttribute("st_cod_verificacion");
    %>
        <div class="container h-100">
            <div class="row h-100 align-items-center justify-content-center">
                <form method="post" action="FactorAutenticacion" class="col-8 bg-light rounded p-1 justify-content-center">
                        <div class="row g-2 p-2 justify-content-center"> 
                            <div class="col-auto">
                                <h2>Autenticación de código</h2>
                            </div>
                        </div>
                        <div class="row g-2 p-2 justify-content-center"> 
                            <div class="col-auto">
                                <p>A tu correo fue enviado un codigo de autenticación de 6 dígitos, escribe dicho código:</p>
                            </div>
                        </div>
                    <div class="row justify-content-center">
                        <div class="col-7 form-group align-items-center fw-bold">
                            <label for="codigoVerificacion">Código:</label>
                        </div>
                    </div>
                    <div class="row w-100 justify-content-center">
                        
                        <div class="col-7 form-group align-items-center">
                            <input class="form-control" type="text" name="cod_verificacion" estado=<%=estadoCodigo%> id="codigoVerificacion"><br><br>
                        </div>
                        <div class="col-1 align-items-center">
                            <button type="submit" class="btn btn-primary">Autenticar</button>  
                        </div>
                    </div>
                        <div class="row g-2 p-1 justify-content-center"> 
                            <div class="col-auto">
                                <p>
                                    Ir a
                                    <a href="Login.jsp"> inicio de sesion </a>
                                    o
                                    <a href="Registro.jsp"> registro </a>
                                </p>
                            </div>
                        </div>
                <jsp:include page="vista/ListaErrores.jsp" />
                </form>
            </div>
        </div>

</body>
</html>