package br.edu.ifsp.dsw1.model.flightstates;

import br.edu.ifsp.dsw1.model.entity.FlightData;

public class TookOff implements State {
    // Instância única do estado TookOff (padrão Singleton)
    private static TookOff instance = null;

    // Construtor privado para evitar a criação de múltiplas instâncias
    private TookOff() { }

    // Método para obter a instância única de TookOff (Singleton)
    public static TookOff getIntance() {
        if (instance == null) {
            instance = new TookOff(); // Cria a instância se for a primeira vez
        }
        return instance;
    }

    // Implementação do método 'change' que não altera o estado de voo, pois já está no estado final
    @Override
    public void change(FlightData flight) {
        // Não há alteração de estado aqui, pois TookOff é o estado final
    }
}
