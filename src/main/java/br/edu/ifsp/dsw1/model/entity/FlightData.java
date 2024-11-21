package br.edu.ifsp.dsw1.model.entity;

import br.edu.ifsp.dsw1.model.flightstates.State;

public final class FlightData {
    // Atributos da classe FlightData (dados de voo)
    private final Long flightNumber;  // Número do voo
    private final String company;     // Companhia aérea
    private final String time;        // Horário do voo
    private State state;              // Estado atual do voo (utilizando o padrão State)

    // Construtor da classe, inicializando os dados do voo
    public FlightData(Long flightNumber, String company, String time) {
        super();
        this.flightNumber = flightNumber;
        this.company = company;
        this.time = time;
    }

    // Getter para obter o estado atual do voo
    public State getState() {
        return state;
    }

    // Setter para alterar o estado do voo
    public void setState(State state) {
        this.state = state;
    }

    // Getter para obter o número do voo
    public Long getFlightNumber() {
        return flightNumber;
    }

    // Getter para obter o nome da companhia aérea
    public String getCompany() {
        return company;
    }

    // Getter para obter o horário do voo
    public String getTime() {
        return time;
    }

    // Sobrescreve o método toString para uma representação customizada do voo
    @Override
    public String toString() {
        return "FlightData [flightNumber=" + flightNumber +
                ", company=" + company +
                ", time=" + time +
                ", state="
                + state.getClass().getSimpleName() + "]";
    }
}
