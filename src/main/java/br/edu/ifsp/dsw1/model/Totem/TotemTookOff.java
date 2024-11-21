package br.edu.ifsp.dsw1.model.Totem;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.flightstates.TookOff;

public class TotemTookOff extends Totem {

    public TotemTookOff() {
        super();
    }

    @Override
    public void update(FlightData flight) {
        if(flight.getState() instanceof TookOff) {
            flights.add(flight);
        }
        else{
            flights.remove(flight);
        }
    }

}
