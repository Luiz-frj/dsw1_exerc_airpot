package br.edu.ifsp.dsw1.model.Totem;

import br.edu.ifsp.dsw1.model.flightstates.Boarding;
import br.edu.ifsp.dsw1.model.entity.FlightData;

public class TotemBoarding extends Totem {

    public TotemBoarding() {
        super();
    }

    @Override
    public void update(FlightData flight) {
        if(flight.getState() instanceof Boarding) {
            flights.add(flight);
        }else{
            flights.remove(flight);
        }
    }

}