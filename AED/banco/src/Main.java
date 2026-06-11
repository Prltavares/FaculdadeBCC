import sistema.SimuladorBanco;

/**
 * Ponto de entrada da aplicação.
 * Instancia e inicia o simulador de atendimento bancário.
 */
public class Main {

    public static void main(String[] args) {
        SimuladorBanco simulador = new SimuladorBanco();
        simulador.iniciar();
    }
}
