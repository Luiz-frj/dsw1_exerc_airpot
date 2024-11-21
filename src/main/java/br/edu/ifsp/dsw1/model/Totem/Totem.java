package br.edu.ifsp.dsw1.model.Totem;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.observer.FlightDataObserver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Totem implements FlightDataObserver {

    protected List<FlightData> flights;

    public Totem() {
        flights = new LinkedList<FlightData>();
    }

    public void remove(FlightData flight) {
        flights.remove(flight);
    }

    public List<FlightData> getAllFlights(){
        return new ArrayList<FlightData>(flights);
    }
}
