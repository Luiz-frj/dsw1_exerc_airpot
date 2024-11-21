package br.edu.ifsp.dsw1.model.Totem;

// Importa a classe que representa o estado "Arriving".
import br.edu.ifsp.dsw1.model.flightstates.Arriving;
import br.edu.ifsp.dsw1.model.entity.FlightData;

// Classe que representa o Totem específico para voos no estado "Arriving".
public class TotemArriving extends Totem {

    public TotemArriving() {
        super();
    }

    @Override
    public void update(FlightData flight) {
        //Se o estado do voo for "Arriving", adiciona à lista de voos do totem
        if(flight.getState() instanceof Arriving) {
            flights.add(flight);
        }else{
            flights.remove(flight);
        }
    }

}
