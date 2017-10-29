package com.project.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "EarningsServlet", urlPatterns = {"/earnings"})
public class EarningsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if ( session != null ) {
            if (session.getAttribute("username") != null && session.getAttribute("type").equals("grossiste")){
                System.out.println("username " + session.getAttribute("username"));
                System.out.println("type : "  + session.getAttribute("type"));
                response.sendRedirect("earnings.jsp");
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
