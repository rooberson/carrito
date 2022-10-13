<%@page import="java.util.ArrayList"%>

<%
    ///verificacion existe la coleccion el objeto session
    if (session.getAttribute("lista") == null) {
        //inicializar la lista auxiliar
        ArrayList<String> lis = new ArrayList<String>();
        ///creando un atributo con un coleccion vacia
        session.setAttribute("lista", lis);

    }
    ArrayList<String> lista = (ArrayList<String>) session.getAttribute("lista");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Carrito de Compras</h1>
        <p>Inserte los productos que desea</p>
        <form action="ProcesaServlet" method="POST">
            producto: <input type="text" name="producto" value="" />
            <input type="submit"  value="Enviar" />     
        </form>
        <br>   
        <a href="ProcesaServlet">Vaciar carrito</a>
        <h3>Contenido del carrito</h3>
        <ul>
            <%            if (lista != null) {
                    for (String item : lista) {
            %>
            <li><%=item%> </li>
                <%
                        }
                    }
                %>
        </ul>

    </body>
</html>
