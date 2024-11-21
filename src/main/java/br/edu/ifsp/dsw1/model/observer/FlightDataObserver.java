package br.edu.ifsp.dsw1.model.observer;

// Importando a classe FlightData que será usada no método update
import br.edu.ifsp.dsw1.model.entity.FlightData;

public interface FlightDataObserver {

    // Método que será chamado para notificar o observer sobre a atualização do voo
    // 'flight' é o objeto que contém as informações do voo a serem processadas pelo observer
    void update(FlightData flight);
}
