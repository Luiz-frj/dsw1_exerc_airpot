package br.edu.ifsp.dsw1.model.entity;

public class FlightDataSingleton {

    // Armazena uma única instância FlightDataCollection (Classe)
    private static FlightDataCollection instance;

    //Construtor privado para evitar que se crie outro objeto fora da classe
    private FlightDataSingleton(){}

    //Metodo, sincronizado, para se obter a instancia unica
    public static synchronized FlightDataCollection getInstance() {
        //Verifica se ainda não foi criada
        if (instance == null){

            //Caso não tenha sido criada, cria a mesma
            instance = new FlightDataCollection();
        }
        return instance;
    }

}
