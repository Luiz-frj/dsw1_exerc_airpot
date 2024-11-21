package br.edu.ifsp.dsw1.model.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.edu.ifsp.dsw1.model.flightstates.TookOff;
import br.edu.ifsp.dsw1.model.observer.FlightDataObserver;
import br.edu.ifsp.dsw1.model.observer.FlightDataSubject;

public class FlightDataCollection implements FlightDataSubject{

    // Lista para armazenar os voos
    private List<FlightData> flights;
    // Lista para armazenar os observers registrados
    private List<FlightDataObserver> observers;
    // Último voo atualizado (para notificação aos observers)
    private FlightData lastUpdated;

    // Construtor que inicializa as listas
    public FlightDataCollection() {
        this.flights = new LinkedList<FlightData>();
        this.observers = new LinkedList<FlightDataObserver>();
    }

    // Registra um novo observer para ser notificado
    @Override
    public void register(FlightDataObserver observer) {
        observers.add(observer);
    }

    // Desfaz o registro de um observer
    @Override
    public void unregister(FlightDataObserver observer) {
        observers.remove(observer);
    }

    // Notifica todos os observers registrados sobre a atualização do último voo
    @Override
    public void notifyObservers() {
        observers.stream()
                .forEach(observer -> observer.update(lastUpdated));
    }

    // Insere um novo voo na coleção e notifica os observers
    public void insertFlight(FlightData flight) {
        if (flight != null) {
            lastUpdated = flight;  // Atualiza o último voo modificado
            flights.add(flight);    // Adiciona o voo à lista
            notifyObservers();      // Notifica os observers sobre a mudança
        }
    }

    // Atualiza o estado de um voo pelo seu número e notifica os observers
    public void updateFlight(Long flightNumber) {
        var flight = findByNumber(flightNumber); // Busca o voo pelo número
        if (flight != null) {
            flight.getState().change(flight); // Chama o método 'change' para alterar o estado
            // Se o voo já decolou, remove da lista
            if (flight.getState() instanceof TookOff) {
                flights.remove(flight);
            }
            lastUpdated = flight; // Atualiza o último voo modificado
            notifyObservers();    // Notifica os observers sobre a mudança
        }
    }

    // Retorna todos os voos como uma lista
    public List<FlightData> getAllFligthts() {
        return new ArrayList<FlightData>(flights);
    }

    // Método privado para buscar um voo pela numeração
    private FlightData findByNumber(Long flightNumber) {
        return flights.stream()
                .filter(flight -> flight.getFlightNumber().equals(flightNumber))
                .findFirst()
                .orElse(null);  // Retorna o voo se encontrado, ou null se não encontrado
    }
}
