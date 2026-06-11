package guiches;

import estruturas.Fila;
import modelo.RegistroAtendimento;

/**
 * Guichê preferencial: atende SEMPRE clientes prioritários primeiro.
 * Só atende da fila normal quando a fila prioritária estiver completamente vazia.
 */
public class AtendimentoPreferencial extends Guiche {

    /**
     * @param filaPrioritaria fila compartilhada de clientes prioritários
     * @param filaNormal      fila compartilhada de clientes normais
     */
    public AtendimentoPreferencial(Fila<RegistroAtendimento> filaPrioritaria,
                                   Fila<RegistroAtendimento> filaNormal) {
        super("Preferencial", filaPrioritaria, filaNormal);
    }

    /**
     * Regra do guichê preferencial:
     * 1. Se houver cliente prioritário → atende prioritário.
     * 2. Se a fila prioritária estiver vazia → atende normal.
     * 3. Se ambas estiverem vazias → retorna null.
     *
     * @return cliente selecionado, ou null se não houver nenhum
     */
    @Override
    protected RegistroAtendimento selecionarProximoCliente() {
        if (!filaPrioritaria.vazia()) {
            return filaPrioritaria.dequeue();
        }
        if (!filaNormal.vazia()) {
            return filaNormal.dequeue();
        }
        return null;
    }
}
