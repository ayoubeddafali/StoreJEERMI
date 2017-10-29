package com.project.servlets;
import com.project.metier.IGrossisteMetier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;


@WebServlet(name = "AddProductServlet", urlPatterns = {"/addProduct"})
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_name = request.getParameter("name");
        String product_price = request.getParameter("price");
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        try {
            IGrossisteMetier grossiste = (IGrossisteMetier) Naming.lookup("rmi://localhost/grossiste");
            if (grossiste.addProduct(username, product_name, product_price)){
                response.sendRedirect("products.jsp");
            }
        }catch (NotBoundException e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if ( session != null ) {
            if (session.getAttribute("username") != null && session.getAttribute("type").equals("grossiste")){
                System.out.println("username " + session.getAttribute("username"));
                System.out.println("type : "  + session.getAttribute("type"));
                response.sendRedirect("addProduct.jsp");
            }else {
                response.sendRedirect("actionNotAllowed.jsp");
            }
        }
        else
        {
            response.sendRedirect("notLoggedIn.jsp");
        }
    }
}
