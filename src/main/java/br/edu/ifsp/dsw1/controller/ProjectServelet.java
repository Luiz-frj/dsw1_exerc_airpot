package br.edu.ifsp.dsw1.controller;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
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
    private static final FlightDataCollection dataSource = new FlightDataCollection();


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String view = "";

        switch (action){
            case "login":
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
                break;

            case "logout":
                HttpSession sessao = req.getSession(false);
                sessao.invalidate();

                view = "index.jsp";

                break;

            case "cadastro":
                Long number = Long.parseLong(req.getParameter("numero"));
                String agencia = req.getParameter("agencia");
                String horario = req.getParameter("horario");

                dataSource.insertFlight(new FlightData(number, agencia, horario));

                view = "cadastroVoos.jsp";

                break;

            case "update":
                view ="voostable.jsp";

                break;
        }

        var dispacher = req.getRequestDispatcher(view);
        dispacher.forward(req, resp);

    }

}
