package guiches;

import estruturas.Fila;
import modelo.RegistroAtendimento;

/**
 * Guichê geral: implementa alternância entre filas para equilibrar o tempo
 * de espera dos clientes normais. Pode ser instanciado como "Geral 1" ou "Geral 2".
 *
 * Regra de alternância:
 * - Se houver prioritário e o ÚLTIMO atendimento NÃO foi prioritário → atende prioritário.
 * - Após atender um prioritário → próximo deve ser normal (se disponível).
 * - Se uma fila estiver vazia → atende a outra disponível.
 * - Se ambas vazias → retorna null.
 */
public class AtendimentoGeral extends Guiche {

    /**
     * Controla a alternância: true = próximo preferência é NORMAL.
     * Começa false para priorizar um prioritário no primeiro atendimento.
     */
    private boolean proximoDeveSerNormal;

    /**
     * @param nome            identificador do guichê ("Geral 1" ou "Geral 2")
     * @param filaPrioritaria fila compartilhada de clientes prioritários
     * @param filaNormal      fila compartilhada de clientes normais
     */
    public AtendimentoGeral(String nome,
                            Fila<RegistroAtendimento> filaPrioritaria,
                            Fila<RegistroAtendimento> filaNormal) {
        super(nome, filaPrioritaria, filaNormal);
        this.proximoDeveSerNormal = false;
    }

    /**
     * Lógica de alternância dos guichês gerais.
     * Garante que clientes normais não esperem indefinidamente.
     *
     * @return cliente selecionado, ou null se não houver nenhum
     */
    @Override
    protected RegistroAtendimento selecionarProximoCliente() {

        // ── Caso 1: ambas as filas vazias ─────────────────────────────────────
        if (filaPrioritaria.vazia() && filaNormal.vazia()) {
            return null;
        }

        // ── Caso 2: apenas uma fila disponível ────────────────────────────────
        if (filaPrioritaria.vazia()) {
            // Só há normais: atende normal, próximo volta a poder ser prioritário
            proximoDeveSerNormal = false;
            return filaNormal.dequeue();
        }
        if (filaNormal.vazia()) {
            // Só há prioritários: atende prioritário, próximo deve ser normal
            proximoDeveSerNormal = true;
            return filaPrioritaria.dequeue();
        }

        // ── Caso 3: ambas as filas têm clientes — aplica alternância ──────────
        if (proximoDeveSerNormal) {
            // Após um prioritário → vez do normal
            proximoDeveSerNormal = false;   // próximo pode ser prioritário novamente
            return filaNormal.dequeue();
        } else {
            // Vez do prioritário
            proximoDeveSerNormal = true;    // próximo deve ser normal
            return filaPrioritaria.dequeue();
        }
    }
}
