package br.edu.ifsp.dsw1.controller;

import br.edu.ifsp.dsw1.model.Totem.TotemTookOff;
import br.edu.ifsp.dsw1.model.entity.*;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;
import br.edu.ifsp.dsw1.model.observer.FlightDataObserver;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/adm.do")
public class ProjectServelet extends HttpServlet{

    private static final long serialVersionUID = 1L;
    private final String email = "admin";
    private final String password = "admin";
    private static final FlightDataCollection dataSource = new FlightDataCollection();

    private TotemArriving arriving = new TotemArriving();
    private TotemBoarding boarding = new TotemBoarding();
    private TotemTakingOff takingOff = new TotemTakingOff();
    private TotemTookOff tookOff = new TotemTookOff();


    @Override
    public void init() throws ServletException {
        super.init();

        dataSource.register(arriving);
        dataSource.register(boarding);
        dataSource.register(takingOff);
        dataSource.register(tookOff);
    }

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

                view = "cadastroVoos.jsp";

                break;

            case "novoVoo":

                Long number = Long.parseLong(req.getParameter("numero"));
                String agencia = req.getParameter("agencia");
                String horario = req.getParameter("horario");

                FlightData voo = new FlightData(number, agencia, horario);
                voo.setState(Arriving.getIntance());

                dataSource.insertFlight(voo);


                view = "cadastroVoos.jsp";

                break;

            case "tabela":

                req.setAttribute("voos", dataSource.getAllFligthts());

                view ="voostable.jsp";

                break;

            case "tabelaEmbarque":
                req.setAttribute("voos", dataSource.getAllFligthts());

                view = "TabelaVoosEmbarque.jsp";

                break;

            case "tabelaDesembarque":

                req.setAttribute("voos", dataSource.getAllFligthts());

                view = "TabelaVoosDesembarque.jsp";

                break;

            case "update":

                dataSource.updateFlight(Long.parseLong(req.getParameter("numero")));

                System.out.println("O voo de numero" + req.getParameter("numero") + "mudou de estado");

                req.setAttribute("voos", dataSource.getAllFligthts());

                dataSource.notifyObservers();

                view ="voostable.jsp";

                break;
        }

        var dispacher = req.getRequestDispatcher(view);
        dispacher.forward(req, resp);

    }

}
