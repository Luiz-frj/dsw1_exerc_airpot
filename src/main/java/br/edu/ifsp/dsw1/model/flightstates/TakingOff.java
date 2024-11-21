package br.edu.ifsp.dsw1.model.flightstates;

import br.edu.ifsp.dsw1.model.entity.FlightData;

public class TakingOff implements State {
    // Instância única do estado TakingOff (padrão Singleton)
    private static TakingOff instance = null;

    // Construtor privado para evitar a criação de múltiplas instâncias
    private TakingOff() { }

    // Método para obter a instância única de TakingOff (Singleton)
    public static TakingOff getIntance() {
        if (instance == null) {
            instance = new TakingOff(); // Cria a instância se for a primeira vez
        }
        return instance;
    }

    // Implementação do método 'change' que altera o estado do voo
    @Override
    public void change(FlightData flight) {
        // Ao decolar, o voo muda para o estado TookOff (Decolado)
        flight.setState(TookOff.getIntance());
    }
}
