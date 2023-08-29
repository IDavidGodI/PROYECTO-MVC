
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<jsp:include page="/envioCorreos" />--%>
<!DOCTYPE html>

<html>
<head>
    <%
        response.sendRedirect("Registro.jsp");
    %>
    <title>Código de verificación</title>
    <style>
            body {
                    font-family: Arial, sans-serif;
                    background-color: #F7F7F7;
            }
            h3 {
                    text-align: center;
                    color: #555555;
            }
            #codigo {
                    text-align: center;
                    font-size: 36px;
                    color: #2196F3;
                    margin: 20px 0;
            }
            img {
                    display: block;
                    margin: 0 auto;
                    max-width: 100%;
                    height: auto;
            }
    </style>
</head>
<body>
    <h3>Código de verificación:</h3>
    <div id="codigo"><%= request.getAttribute("cod_verificacion") %></div>
    <img src="<%= request.getAttribute("imagen_correo") %>" alt="No fue posible cargar el gif :(">
</body>
</html>