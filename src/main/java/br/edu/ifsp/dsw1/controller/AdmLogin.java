package br.edu.ifsp.dsw1.controller;

import br.edu.ifsp.dsw1.controller.command.AdmCommand.*;
import br.edu.ifsp.dsw1.controller.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/adm.do")
public class AdmLogin extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        Command command = null;

        if ("login".equals(action)) {
            command = new LoginCommand();
        } else if ("logout".equals(action)) {
            command = new LogoutCommand();
        } else if ("cadastro".equals(action)) {
            command = new VooCadastroCommand();
        } else if ("update".equals(action)) {
            command = new UpdateCommand();
        } else if ("sendUpdate".equals(action)) {
            command = new SendUpdateCommand();
        }

        String view = command.execute(req, resp);
        var dispatcher = req.getRequestDispatcher(view);
        dispatcher.forward(req, resp);

    }

}
