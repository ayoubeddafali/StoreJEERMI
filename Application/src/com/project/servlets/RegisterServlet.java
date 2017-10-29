package com.project.servlets;

import com.project.metier.IClientMetier;
import com.project.metier.IGrossisteMetier;
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

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        if (type.equalsIgnoreCase("client")){
            try {
                IClientMetier client = (IClientMetier) Naming.lookup("rmi://localhost/client");
                if (client.register(username, password, type)){
                    response.sendRedirect("/");
                }
            }catch (NotBoundException e){
                e.printStackTrace();
            }
        }
        else if (type.equalsIgnoreCase("grossiste")){
            try {
                IGrossisteMetier grossiste = (IGrossisteMetier) Naming.lookup("rmi://localhost/grossiste");
                grossiste.register(username, password, type);
            }catch (NotBoundException e){
                e.printStackTrace();
            }
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.sendRedirect("/");
    }
}
