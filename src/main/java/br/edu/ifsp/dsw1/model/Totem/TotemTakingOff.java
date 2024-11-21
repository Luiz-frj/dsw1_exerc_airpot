package br.edu.ifsp.dsw1.model.Totem;

// Importa a classe que representa o estado "TakingOff".
import br.edu.ifsp.dsw1.model.flightstates.TakingOff;
import br.edu.ifsp.dsw1.model.entity.FlightData;

// Classe que representa o Totem específico para voos no estado "TakingOff".
public class TotemTakingOff extends Totem {

    // Construtor padrão, inicializa a lista de voos utilizando o construtor da classe pai.
    public TotemTakingOff() {
        super();
    }

    @Override
    public void update(FlightData flight) {
        // Verifica se o estado do voo é "TakingOff".
        if (flight.getState() instanceof TakingOff) {
            // Adiciona o voo à lista caso ele esteja no estado "TakingOff".
            flights.add(flight);
        } else {
            // Remove o voo da lista caso ele mude para outro estado.
            flights.remove(flight);
        }
    }
}
