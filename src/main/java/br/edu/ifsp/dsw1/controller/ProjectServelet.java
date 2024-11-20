package br.edu.ifsp.dsw1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/adm.do")
public class ProjectServelet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final String email = "admin";
    private final String password = "admin";


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String view = "";

        if ("login".equals(action)){
            String name = req.getParameter("email");
            String senha = req.getParameter("password");
            String msg = "";
            if(email.equals(name) && password.equals(senha)){
                HttpSession session = req.getSession();

                session.setAttribute("Usuario", email);
                session.setMaxInactiveInterval(5 * 60);

                view = "escolhaadm.jsp";
            }else {
                req.setAttribute(msg, "Erro ao entrar");
                view = "admErro.jsp";
            }
        } else {
            if("logout".equals(action)){
                HttpSession sessao = req.getSession(false);
                sessao.invalidate();

                view = "index.jsp";
            } else {
                if("cadastro".equals(action)){
                    view = "cadastroVoos.jsp";
                } else{
                    if("update".equals(action)){
                        view ="voostable.jsp";
                    }
                }
            }
        }

        var dispacher = req.getRequestDispatcher(view);
        dispacher.forward(req, resp);

    }

}