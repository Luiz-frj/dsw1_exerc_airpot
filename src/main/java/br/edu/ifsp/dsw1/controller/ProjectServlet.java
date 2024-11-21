package br.edu.ifsp.dsw1.controller;

// Importa classes necessárias para o funcionamento da Servlet e manipulação de dados.
import br.edu.ifsp.dsw1.model.Totem.TotemArriving;
import br.edu.ifsp.dsw1.model.Totem.TotemBoarding;
import br.edu.ifsp.dsw1.model.Totem.TotemTakingOff;
import br.edu.ifsp.dsw1.model.Totem.TotemTookOff;
import br.edu.ifsp.dsw1.model.entity.*;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// Define a URL que ativa essa Servlet.
@WebServlet("/adm.do")
public class ProjectServlet extends HttpServlet {

    private static final long serialVersionUID = 1L; // Identificador único da classe para serialização.

    private final String email = "admin"; // Credencial fixa para login de administrador.
    private final String password = "admin"; // Senha fixa para login.

    private static final FlightDataCollection dataSource = new FlightDataCollection(); // Coleção que armazena os dados de voos.

    // Instâncias dos "totens" que representam diferentes estados de um voo.
    private TotemArriving arriving = new TotemArriving();
    private TotemBoarding boarding = new TotemBoarding();
    private TotemTakingOff takingOff = new TotemTakingOff();
    private TotemTookOff tookOff = new TotemTookOff();

    @Override
    public void init() throws ServletException {
        super.init();

        // Registra os totens no dataSource, seguindo o padrão Observer.
        dataSource.register(arriving);
        dataSource.register(boarding);
        dataSource.register(takingOff);
        dataSource.register(tookOff);
    }

    // Trata requisições GET, redirecionando para o método processRequest.
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    // Trata requisições POST, redirecionando para o método processRequest.
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    // Método central que processa as ações baseadas no parâmetro "action".
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action"); // Obtém a ação da requisição.
        String view = ""; // Variável para definir qual página será exibida.

        // Avalia a ação recebida.
        switch (action) {

            case "login": // Ação de login.
                String name = req.getParameter("email"); // Obtém o e-mail inserido.
                String senha = req.getParameter("password"); // Obtém a senha inserida.
                String msg = "";

                if (email.equals(name) && password.equals(senha)) { // Verifica se as credenciais são válidas.
                    HttpSession session = req.getSession(); // Cria uma sessão.
                    session.setAttribute("Usuario", email); // Salva o usuário na sessão.
                    session.setMaxInactiveInterval(5 * 60); // Define o tempo máximo de inatividade da sessão.

                    view = "escolhaadm.jsp"; // Redireciona para a página principal do admin.

                } else {
                    req.setAttribute(msg, "Erro ao entrar"); // Define uma mensagem de erro.

                    view = "admErro.jsp"; // Redireciona para a página de erro.
                }

                break;

            case "logout": // Ação de logout.
                HttpSession sessao = req.getSession(false); // Obtém a sessão atual, sem criar uma nova.

                sessao.invalidate(); // Finaliza a sessão.

                view = "index.jsp"; // Redireciona para a página inicial.

                break;

            case "cadastro": // Ação de redirecionamento para a página de cadastro.

                view = "cadastroVoos.jsp"; // Define a página de cadastro como destino.

                break;

            case "novoVoo": // Ação para criar um novo voo.
                Long number = Long.parseLong(req.getParameter("numero")); // Número do voo.
                String agencia = req.getParameter("agencia"); // Agência responsável.
                String horario = req.getParameter("horario"); // Horário do voo.

                FlightData voo = new FlightData(number, agencia, horario); // Cria o objeto do voo.

                voo.setState(Arriving.getIntance()); // Define o estado inicial do voo como "Arriving".

                dataSource.insertFlight(voo); // Insere o voo na base de dados.

                arriving.update(voo); // Atualiza o totem relacionado ao estado "Arriving".

                view = "cadastroVoos.jsp"; // Redireciona para a página de cadastro.

                break;

            case "tabela": // Ação para exibir todos os voos.

                req.setAttribute("voos", dataSource.getAllFligthts()); // Adiciona os voos à requisição.

                view = "voostable.jsp"; // Redireciona para a tabela de voos.

                break;

            case "tabelaEmbarque": // Ação para exibir voos em estado de embarque.

                req.setAttribute("voos", dataSource.getAllFligthts()); // Adiciona os voos à requisição.

                view = "TabelaVoosEmbarque.jsp"; // Redireciona para a tabela específica.

                break;

            case "tabelaDesembarque": // Ação para exibir voos em estado de desembarque.

                req.setAttribute("voos", dataSource.getAllFligthts()); // Adiciona os voos à requisição.

                view = "TabelaVoosDesembarque.jsp"; // Redireciona para a tabela específica.

                break;

            case "update": // Ação para atualizar o estado de um voo.

                dataSource.updateFlight(Long.parseLong(req.getParameter("numero"))); // Atualiza o estado do voo pelo número.

                System.out.println("O voo de número " + req.getParameter("numero") + " mudou de estado"); // Loga a atualização.

                req.setAttribute("voos", dataSource.getAllFligthts()); // Adiciona os voos atualizados à requisição.

                dataSource.notifyObservers(); // Notifica os observadores das alterações.

                view = "voostable.jsp"; // Redireciona para a tabela de voos.

                break;
        }

        // Redireciona para a página definida em "view".
        var dispacher = req.getRequestDispatcher(view);
        dispacher.forward(req, resp);
    }
}
