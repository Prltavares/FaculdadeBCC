package guiches;

import estruturas.Fila;
import estruturas.Pilha;
import modelo.RegistroAtendimento;

/**
 * Classe abstrata que representa um guichê de atendimento bancário.
 * Define o comportamento comum a todos os guichês e obriga subclasses
 * a implementar a lógica de seleção de qual fila atender.
 */
public abstract class Guiche {

    protected final String nome;

    /** Fila de clientes prioritários (compartilhada com todos os guichês). */
    protected final Fila<RegistroAtendimento> filaPrioritaria;

    /** Fila de clientes normais (compartilhada com todos os guichês). */
    protected final Fila<RegistroAtendimento> filaNormal;

    /** Histórico LIFO dos atendimentos realizados por ESTE guichê. */
    protected final Pilha<RegistroAtendimento> historico;

    /** Relógio interno: minuto atual do sistema (passado pelo simulador). */
    protected int relogioAtual;

    /** Contador de atendimentos normais realizados neste guichê. */
    protected int totalNormais;

    /** Contador de atendimentos prioritários realizados neste guichê. */
    protected int totalPrioritarios;

    /**
     * @param nome             nome identificador do guichê
     * @param filaPrioritaria  fila compartilhada de clientes prioritários
     * @param filaNormal       fila compartilhada de clientes normais
     */
    protected Guiche(String nome,
                     Fila<RegistroAtendimento> filaPrioritaria,
                     Fila<RegistroAtendimento> filaNormal) {
        this.nome = nome;
        this.filaPrioritaria = filaPrioritaria;
        this.filaNormal = filaNormal;
        this.historico = new Pilha<>();
        this.relogioAtual = 0;
        this.totalNormais = 0;
        this.totalPrioritarios = 0;
    }

    /**
     * Define o minuto atual do simulador (antes de chamar o próximo cliente).
     *
     * @param minuto minuto corrente da simulação
     */
    public void setRelogio(int minuto) {
        this.relogioAtual = minuto;
    }

    /**
     * Template Method: chama o próximo cliente de acordo com a lógica
     * implementada pela subclasse. Registra o atendimento no histórico (pilha).
     *
     * @return o RegistroAtendimento do cliente atendido, ou null se filas vazias
     */
    public RegistroAtendimento chamarProximo() {
        RegistroAtendimento cliente = selecionarProximoCliente();
        if (cliente == null) return null;

        // Registra início do atendimento no modelo
        cliente.iniciarAtendimento(relogioAtual, nome);

        // Empilha no histórico do guichê (LIFO)
        historico.push(cliente);

        // Atualiza contadores
        if (cliente.getTipoCliente() == RegistroAtendimento.TipoCliente.PRIORITARIO) {
            totalPrioritarios++;
        } else {
            totalNormais++;
        }

        return cliente;
    }

    /**
     * Lógica de seleção do próximo cliente — implementada pela subclasse.
     *
     * @return cliente selecionado da fila, ou null se não houver nenhum
     */
    protected abstract RegistroAtendimento selecionarProximoCliente();

    // ─── Getters ──────────────────────────────────────────────────────────────

    public String getNome()               { return nome; }
    public Pilha<RegistroAtendimento> getHistorico() { return historico; }
    public int getTotalNormais()           { return totalNormais; }
    public int getTotalPrioritarios()      { return totalPrioritarios; }
    public int getTotalAtendimentos()      { return totalNormais + totalPrioritarios; }

    /** Retorna todos os atendimentos deste guichê como array (topo→base da pilha). */
    public RegistroAtendimento[] getAtendimentosComoArray() {
        return historico.toArray(new RegistroAtendimento[historico.tamanho()]);
    }

    @Override
    public String toString() {
        return String.format("Guichê [%s] | Total: %d (Prioritários: %d | Normais: %d)",
                nome, getTotalAtendimentos(), totalPrioritarios, totalNormais);
    }
}
