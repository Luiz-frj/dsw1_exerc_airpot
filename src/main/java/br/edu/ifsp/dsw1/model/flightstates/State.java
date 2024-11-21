package br.edu.ifsp.dsw1.model.flightstates;

import br.edu.ifsp.dsw1.model.entity.FlightData;

public interface State {

    // Método que define a mudança de estado de um voo
    // O parâmetro 'flight' é o voo que terá seu estado alterado
    void change(FlightData flight);
}
