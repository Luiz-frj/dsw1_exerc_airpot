package br.edu.ifsp.dsw1.controller.command.AdmCommand;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(false);

        if (sessao == null || sessao.getAttribute("user") == null) {
            request.setAttribute("errorMessage", "Não é possível acessar a página de logout sem estar logado.");
        }

        if (sessao != null) {
            sessao.invalidate();
        }

        return "adm.jsp";
    }

}