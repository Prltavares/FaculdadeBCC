package sistema;

import guiches.Guiche;
import modelo.RegistroAtendimento;
import util.Ordenacao;

/**
 * Responsável por consolidar e exibir o relatório final do sistema de atendimento.
 * Agrega dados de todos os guichês, calcula métricas e aplica ordenação manual.
 */
public class Relatorio {

    private final Guiche[] guiches;

    /**
     * @param guiches array com todos os guichês do sistema
     */
    public Relatorio(Guiche[] guiches) {
        this.guiches = guiches;
    }

    /**
     * Gera e imprime o relatório completo no console.
     * Inclui totais, médias e dois modos de ordenação (MergeSort e QuickSort).
     */
    public void gerarRelatorio() {
        // ── Coleta todos os atendimentos de todos os guichês ──────────────────
        RegistroAtendimento[] todos = coletarTodosAtendimentos();

        if (todos.length == 0) {
            System.out.println("\n╔══════════════════════════════════════════╗");
            System.out.println("║   Nenhum atendimento realizado ainda.    ║");
            System.out.println("╚══════════════════════════════════════════╝");
            return;
        }

        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║              RELATÓRIO CONSOLIDADO DE ATENDIMENTOS              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");

        // ── 1. Totais gerais ──────────────────────────────────────────────────
        imprimirTotaisGerais(todos);

        // ── 2. Detalhamento por guichê ────────────────────────────────────────
        imprimirDetalhesPorGuiche();

        // ── 3. Médias de tempo de espera ──────────────────────────────────────
        imprimirMediasEspera(todos);

        // ── 4. Ordenado por tempo de espera (MergeSort crescente) ─────────────
        imprimirOrdenadoPorEspera(copiarArray(todos));

        // ── 5. Ordenado cronologicamente por horário de atendimento (QuickSort) ─
        imprimirOrdenadoPorHorario(copiarArray(todos));

        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
        System.out.println();
    }

    // ─── Métodos auxiliares de impressão ─────────────────────────────────────

    private void imprimirTotaisGerais(RegistroAtendimento[] todos) {
        int totalPrioritarios = 0;
        int totalNormais = 0;
        for (RegistroAtendimento r : todos) {
            if (r.getTipoCliente() == RegistroAtendimento.TipoCliente.PRIORITARIO) {
                totalPrioritarios++;
            } else {
                totalNormais++;
            }
        }

        System.out.println("┌─────────────────────────────────────────────────────────────────┐");
        System.out.println("│  TOTAIS GERAIS                                                  │");
        System.out.println("├─────────────────────────────────────────────────────────────────┤");
        System.out.printf("│  Total de atendimentos realizados : %-30d│%n", todos.length);
        System.out.printf("│  Clientes prioritários atendidos  : %-30d│%n", totalPrioritarios);
        System.out.printf("│  Clientes normais atendidos       : %-30d│%n", totalNormais);
        System.out.println("└─────────────────────────────────────────────────────────────────┘");
    }

    private void imprimirDetalhesPorGuiche() {
        System.out.println();
        System.out.println("┌─────────────────────────────────────────────────────────────────┐");
        System.out.println("│  DETALHAMENTO POR GUICHÊ                                        │");
        System.out.println("├──────────────────────┬────────┬──────────────┬─────────────────┤");
        System.out.println("│ Guichê               │ Total  │ Prioritários │ Normais         │");
        System.out.println("├──────────────────────┼────────┼──────────────┼─────────────────┤");

        for (Guiche g : guiches) {
            System.out.printf("│ %-20s │ %-6d │ %-12d │ %-15d │%n",
                    g.getNome(),
                    g.getTotalAtendimentos(),
                    g.getTotalPrioritarios(),
                    g.getTotalNormais());
        }
        System.out.println("└──────────────────────┴────────┴──────────────┴─────────────────┘");
    }

    private void imprimirMediasEspera(RegistroAtendimento[] todos) {
        long somaTotal = 0;
        long somaPrioritarios = 0;
        long somaNormais = 0;
        int contPrioritarios = 0;
        int contNormais = 0;

        for (RegistroAtendimento r : todos) {
            int espera = r.getTempoEspera();
            somaTotal += espera;
            if (r.getTipoCliente() == RegistroAtendimento.TipoCliente.PRIORITARIO) {
                somaPrioritarios += espera;
                contPrioritarios++;
            } else {
                somaNormais += espera;
                contNormais++;
            }
        }

        double mediaTotal = todos.length > 0 ? (double) somaTotal / todos.length : 0;
        double mediaPrio  = contPrioritarios > 0 ? (double) somaPrioritarios / contPrioritarios : 0;
        double mediaNorm  = contNormais > 0 ? (double) somaNormais / contNormais : 0;

        System.out.println();
        System.out.println("┌─────────────────────────────────────────────────────────────────┐");
        System.out.println("│  MÉDIAS DE TEMPO DE ESPERA (em minutos)                         │");
        System.out.println("├─────────────────────────────────────────────────────────────────┤");
        System.out.printf("│  Tempo médio geral de espera      : %-10.2f min              │%n", mediaTotal);
        System.out.printf("│  Tempo médio espera prioritários  : %-10.2f min              │%n", mediaPrio);
        System.out.printf("│  Tempo médio espera normais        : %-10.2f min              │%n", mediaNorm);
        System.out.println("└─────────────────────────────────────────────────────────────────┘");
    }

    private void imprimirOrdenadoPorEspera(RegistroAtendimento[] arr) {
        // MergeSort crescente por tempo de espera
        Ordenacao.mergeSortPorEspera(arr, 0, arr.length - 1);

        System.out.println();
        System.out.println("┌─────────────────────────────────────────────────────────────────┐");
        System.out.println("│  ATENDIMENTOS — ORDEM CRESCENTE DE TEMPO DE ESPERA (MergeSort)  │");
        System.out.println("├──────┬─────────────┬──────────┬──────────┬────────┬─────────────┤");
        System.out.println("│  ID  │ Tipo        │ Chegada  │  Início  │ Espera │ Guichê      │");
        System.out.println("├──────┼─────────────┼──────────┼──────────┼────────┼─────────────┤");

        for (RegistroAtendimento r : arr) {
            System.out.printf("│ %4d │ %-11s │ %-8s │ %-8s │ %4d m │ %-11s │%n",
                    r.getIdCliente(),
                    r.getTipoCliente(),
                    RegistroAtendimento.formatarHorario(r.getHorarioChegada()),
                    RegistroAtendimento.formatarHorario(r.getHorarioInicioAtendimento()),
                    r.getTempoEspera(),
                    r.getNomeGuiche());
        }
        System.out.println("└──────┴─────────────┴──────────┴──────────┴────────┴─────────────┘");
    }

    private void imprimirOrdenadoPorHorario(RegistroAtendimento[] arr) {
        // QuickSort por horário de início de atendimento (cronológico)
        Ordenacao.quickSortPorHorario(arr, 0, arr.length - 1);

        System.out.println();
        System.out.println("┌─────────────────────────────────────────────────────────────────┐");
        System.out.println("│  ATENDIMENTOS — ORDEM CRONOLÓGICA DE ATENDIMENTO (QuickSort)     │");
        System.out.println("├──────┬─────────────┬──────────┬──────────┬────────┬─────────────┤");
        System.out.println("│  ID  │ Tipo        │ Chegada  │  Início  │ Espera │ Guichê      │");
        System.out.println("├──────┼─────────────┼──────────┼──────────┼────────┼─────────────┤");

        for (RegistroAtendimento r : arr) {
            System.out.printf("│ %4d │ %-11s │ %-8s │ %-8s │ %4d m │ %-11s │%n",
                    r.getIdCliente(),
                    r.getTipoCliente(),
                    RegistroAtendimento.formatarHorario(r.getHorarioChegada()),
                    RegistroAtendimento.formatarHorario(r.getHorarioInicioAtendimento()),
                    r.getTempoEspera(),
                    r.getNomeGuiche());
        }
        System.out.println("└──────┴─────────────┴──────────┴──────────┴────────┴─────────────┘");
    }

    // ─── Utilitários internos ─────────────────────────────────────────────────

    /**
     * Percorre o histórico (pilha) de todos os guichês e agrega em um único array.
     */
    private RegistroAtendimento[] coletarTodosAtendimentos() {
        // Primeiro: conta total de atendimentos
        int total = 0;
        for (Guiche g : guiches) {
            total += g.getTotalAtendimentos();
        }

        RegistroAtendimento[] resultado = new RegistroAtendimento[total];
        int pos = 0;

        // Depois: copia cada registro
        for (Guiche g : guiches) {
            RegistroAtendimento[] doGuiche = g.getAtendimentosComoArray();
            for (RegistroAtendimento r : doGuiche) {
                resultado[pos++] = r;
            }
        }
        return resultado;
    }

    /**
     * Cria uma cópia rasa do array para não alterar o original ao ordenar.
     */
    private RegistroAtendimento[] copiarArray(RegistroAtendimento[] original) {
        RegistroAtendimento[] copia = new RegistroAtendimento[original.length];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i];
        }
        return copia;
    }
}
