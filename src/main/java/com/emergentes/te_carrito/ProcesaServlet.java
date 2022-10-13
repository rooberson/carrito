package com.emergentes.te_carrito;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProcesaServlet", urlPatterns = {"/ProcesaServlet"})
public class ProcesaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtener acceso al obajeto session
        HttpSession ses = request.getSession();
        //se elimina la sesion
        ses.invalidate();
        //Transfiere el control a index.jsp
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("En el mertodo POST del Servlet");
        //Recupera el producto enviado desde formulario
        String producto = request.getParameter("producto");
        //Se obtiene el acceso a la session
        HttpSession ses = request.getSession();
        ///se obtiene la lista que esta como atributo de session
        ArrayList<String> lista = (ArrayList<String>) ses.getAttribute("lista");
        /// A la coleccion se adiciona el elemento producto
        lista.add(producto);
        ///Se redirecciona a index.jsp
        response.sendRedirect("index.jsp");

    }

}
