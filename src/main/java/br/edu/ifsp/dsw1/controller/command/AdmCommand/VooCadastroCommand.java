package br.edu.ifsp.dsw1.controller.command.AdmCommand;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.FlightDataSingleton;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VooCadastroCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FlightDataCollection collection = FlightDataSingleton.getInstance();

        Long numero = Long.parseLong(request.getParameter("numero"));
        String agencia = request.getParameter("agencia");
        String time = request.getParameter("time");

        boolean flightExists = collection.getAllFligthts().stream().anyMatch(f -> f.getFlightNumber().equals(numero));

        if (flightExists) {
            request.setAttribute("errorMessage", "Já existe um voo com este número.");
            return "cadastroVoos.jsp";
        }

        FlightData flight = new FlightData(numero, agencia, time);
        flight.setState(Arriving.getIntance());
        collection.insertFlight(flight);
        request.setAttribute("sucessMessage", "Voo cadastrado com sucesso.");

        return "cadastroVoos.jsp";
    }

}
