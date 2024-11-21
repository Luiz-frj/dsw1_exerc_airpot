package br.edu.ifsp.dsw1.model.Totem;

// Importa a classe FlightData e FlightDataObserver
import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.observer.FlightDataObserver;

// Importa coleções utilizadas para armazenar os voos.
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Classe abstrata que representa um Totem, implementando o padrão Observer.
public abstract class Totem implements FlightDataObserver {

    // Lista protegida para armazenar os voos monitorados pelo Totem.
    protected List<FlightData> flights;

    // Construtor padrão, inicializando a lista de voos como uma LinkedList.
    public Totem() {
        flights = new LinkedList<FlightData>();
    }

    // Método para retornar todos os voos monitorados pelo Totem.
    // Retorna uma cópia da lista para evitar alterações externas.
    public List<FlightData> getAllFlights() {
        return new ArrayList<FlightData>(flights);
    }
}
