package br.edu.ifsp.dsw1.model.Totem;

// Importa a classe que representa o estado "Boarding".
import br.edu.ifsp.dsw1.model.flightstates.Boarding;
import br.edu.ifsp.dsw1.model.entity.FlightData;

// Classe que representa o Totem específico para voos no estado "Boarding".
public class TotemBoarding extends Totem {

    // Construtor padrão, inicializa a lista de voos utilizando o construtor da classe pai.
    public TotemBoarding() {
        super();
    }

    @Override
    public void update(FlightData flight) {
        // Verifica se o estado do voo é "Boarding".
        if (flight.getState() instanceof Boarding) {
            // Adiciona o voo à lista caso ele esteja no estado "Boarding".
            flights.add(flight);
        } else {
            // Remove o voo da lista caso ele mude para outro estado.
            flights.remove(flight);
        }
    }
}
