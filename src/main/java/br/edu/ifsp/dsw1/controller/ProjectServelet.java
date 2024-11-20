package br.edu.ifsp.dsw1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

    private String processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String view = "";

        if ("login".equals(action)){
            String msg = "";
            if(req.getParameter("email").equals(email)  && req.getParameter("password").equals(password)){
                view = "escolhaadm.jsp";
            }else {
                req.setAttribute(msg, "Erro ao entrar");
                view = "adm.jsp";
            }
        } else {
            if("logout".equals(action)){
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

        return resp.encodeRedirectURL(view);
    }

}
