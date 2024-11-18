package br.edu.ifsp.dsw1.controller.command;

import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;

import com.sun.net.httpserver.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "admcommand", value = "/adm-command")
public class AdmCommand extends HttpServlet {

    private final String email = "admin";
    private final String senha = "admin";
    private FlightDataCollection datasource;

    public void init() throws ServletException{
        super.init();
        datasource = new FlightDataCollection();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (email != req.getParameter("inputEmail") && senha != req.getParameter("inputPassword")){

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
