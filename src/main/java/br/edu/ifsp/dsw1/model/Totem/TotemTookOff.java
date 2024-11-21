package br.edu.ifsp.dsw1.model.Totem;

// Importa a classe que representa o estado "TookOff".
import br.edu.ifsp.dsw1.model.flightstates.TookOff;
import br.edu.ifsp.dsw1.model.entity.FlightData;

// Classe que representa o Totem específico para voos no estado "TookOff".
public class TotemTookOff extends Totem {

    // Construtor padrão, inicializa a lista de voos utilizando o construtor da classe pai.
    public TotemTookOff() {
        super();
    }

    @Override
    public void update(FlightData flight) {
        // Verifica se o estado do voo é "TookOff".
        if (flight.getState() instanceof TookOff) {
            // Adiciona o voo à lista caso ele esteja no estado "TookOff".
            flights.add(flight);
        } else {
            // Remove o voo da lista caso ele mude para outro estado.
            flights.remove(flight);
        }
    }
}
