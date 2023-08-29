<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <title>Autenticación de código</title>
</head>
<body>
    <%
        String estadoCodigo = (String) request.getAttribute("st_cod_verificacion");
    %>
    <div class="container">
        <h2>Autenticación de código</h2>
        <p>A tu correo fue enviado un codigo de autenticación de 6 dígitos, escribe dicho código:</p>
        <form method="post" action="FactorAutenticacion">
                <div class="form-group m-4">
                    <label for="codigoVerificacion">Código:</label>
                    <input type="text" name="cod_verificacion" estado=<%=estadoCodigo%> id="codigoVerificacion"><br><br>
                  <input type="password" name="cclave" class="form-control" id="cClaveProfesor" placeholder="Confirmar Clave">
                </div>
                <div class="d-grid gap-2 m-4">
                    <button type="submit" class="btn btn-primary">Autenticar</button>  
                </div>
                <p>
                    Ir a
                    <a href="Login.jsp"> inicio de sesion </a>
                    o
                    <a href="Registro.jsp"> registro </a>
                </p>
        </form>
        
        <jsp:include page="vista/ListaErrores.jsp" />
        
    </div>
</body>
</html>