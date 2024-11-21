package br.edu.ifsp.dsw1.model.flightstates;

import br.edu.ifsp.dsw1.model.entity.FlightData;

public class Arriving implements State {

    // Instância única do estado Arriving (padrão Singleton)
    private static Arriving instance = null;

    // Construtor privado para evitar criação de múltiplas instâncias
    private Arriving() { }

    // Método para obter a instância única de Arriving (Singleton)
    public static Arriving getIntance() {
        if (instance == null) {
            instance = new Arriving(); // Cria a instância se for a primeira vez
        }
        return instance;
    }

    // Implementação do método 'change' que altera o estado do voo
    @Override
    public void change(FlightData flight) {
        // Ao chegar, o voo muda para o estado de Boarding (Embarque)
        flight.setState(Boarding.getIntance());
    }
}
