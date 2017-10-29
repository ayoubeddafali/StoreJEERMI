package com.project.servlets;

import com.project.metier.IClientMetier;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.sql.ResultSet;


@WebServlet(name = "PurchaseServlet", urlPatterns = {"/purchase"})
public class PurchaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int product_id = Integer.parseInt(request.getParameter("product_id"));
        HttpSession session = request.getSession();
        if (session != null ){
            String username = (String)session.getAttribute("username");
            try {
                IClientMetier client = (IClientMetier) Naming.lookup("rmi://localhost/client");
                if (client.purchaseProduct(username, product_id)){
                    response.sendRedirect("products.jsp");
                }
            }catch (NotBoundException e){
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/products");
        dispatcher.forward(request, response);
    }
}
