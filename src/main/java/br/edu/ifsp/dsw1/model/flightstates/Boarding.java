package br.edu.ifsp.dsw1.model.flightstates;

import br.edu.ifsp.dsw1.model.entity.FlightData;

public class Boarding implements State {

    // Instância única do estado Boarding (padrão Singleton)
    private static Boarding instance = null;

    // Construtor privado para evitar a criação de múltiplas instâncias
    private Boarding() { }

    // Método para obter a instância única de Boarding (Singleton)
    public static Boarding getIntance() {
        if (instance == null) {
            instance = new Boarding(); // Cria a instância se for a primeira vez
        }
        return instance;
    }

    // Implementação do método 'change' que altera o estado do voo
    @Override
    public void change(FlightData flight) {
        // Ao embarcar, o voo muda para o estado de TakingOff (Decolagem)
        flight.setState(TakingOff.getIntance());
    }
}
