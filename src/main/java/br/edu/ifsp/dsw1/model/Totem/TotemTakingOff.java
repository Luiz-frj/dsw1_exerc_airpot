package br.edu.ifsp.dsw1.model.Totem;

import br.edu.ifsp.dsw1.model.flightstates.TakingOff;
import br.edu.ifsp.dsw1.model.entity.FlightData;

public class TotemTakingOff extends Totem {

    public TotemTakingOff() {
        super();
    }

    @Override
    public void update(FlightData flight) {
        if(flight.getState() instanceof TakingOff) {
            flights.add(flight);
        }else{
            flights.remove(flight);
        }
    }

}
