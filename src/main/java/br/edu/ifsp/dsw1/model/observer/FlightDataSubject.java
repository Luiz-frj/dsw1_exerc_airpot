package br.edu.ifsp.dsw1.model.observer;

public interface FlightDataSubject {

    // Registra um observer que será notificado sobre mudanças nos dados do voo
    void register(FlightDataObserver observer);

    // Remove um observer, que não será mais notificado sobre mudanças
    void unregister(FlightDataObserver observer);

    // Notifica todos os observers registrados sobre uma mudança
    void notifyObservers();
}
