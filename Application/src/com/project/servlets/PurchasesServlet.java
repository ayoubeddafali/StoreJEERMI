package com.project.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PurchasesServlet", urlPatterns = {"/purchases"})
public class PurchasesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if ( session != null ) {
        if (session.getAttribute("username") != null && session.getAttribute("type") != null){
            System.out.println(session.getAttribute("username"));
            response.sendRedirect("purchases.jsp");
        }else {
            response.sendRedirect("notLoggedIn.jsp");
        }
    }
        else
    {
        response.sendRedirect("notLoggedIn.jsp");
    }
}
}
