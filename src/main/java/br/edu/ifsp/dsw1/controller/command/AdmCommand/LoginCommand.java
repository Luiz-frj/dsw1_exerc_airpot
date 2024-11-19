package br.edu.ifsp.dsw1.controller.command.AdmCommand;

import br.edu.ifsp.dsw1.controller.command.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(email.equals("admin") && password.equals("admin")) {
            HttpSession sessao = request.getSession();

            sessao.setAttribute("email", "admin");
            return "escohaadm.jsp";
        }else {
            request.setAttribute("errorMessage", "Dados de login incorretos.");
            return "adm.jsp?error=true";
        }
    }
}