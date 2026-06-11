package sistema;

import estruturas.Fila;
import guiches.AtendimentoGeral;
import guiches.AtendimentoPreferencial;
import guiches.Guiche;
import modelo.RegistroAtendimento;
import modelo.RegistroAtendimento.TipoCliente;

import java.util.Random;
import java.util.Scanner;

/**
 * Núcleo do simulador bancário. Gerencia filas, guichês e o relógio da simulação.
 * Expõe um menu de console para interação com o usuário.
 */
public class SimuladorBanco {

    // ─── Estruturas compartilhadas ────────────────────────────────────────────

    /** Fila de clientes prioritários (idosos, gestantes, PCDs, etc.) */
    private final Fila<RegistroAtendimento> filaPrioritaria;

    /** Fila de clientes atendimento padrão */
    private final Fila<RegistroAtendimento> filaNormal;

    // ─── Guichês ──────────────────────────────────────────────────────────────

    private final AtendimentoPreferencial guichePreferencial;
    private final AtendimentoGeral guicheGeral1;
    private final AtendimentoGeral guicheGeral2;
    private final Guiche[] todosGuiches;

    // ─── Controle da simulação ────────────────────────────────────────────────

    /** Relógio do simulador em minutos (banco abre às 08:00 = minuto 480). */
    private int relogio;

    /** Gerador de números para tempo de atendimento e para IDs automáticos. */
    private final Random random;

    /** Contador sequencial de IDs de clientes. */
    private int proximoId;

    /** Índice do guichê geral que será chamado na próxima vez (alterna 0/1). */
    private int guicheGeralVez;

    // ─── Relatório ────────────────────────────────────────────────────────────

    private final Relatorio relatorio;

    // ═════════════════════════════════════════════════════════════════════════

    /** Cria o simulador com relógio iniciando às 08:00 (480 minutos). */
    public SimuladorBanco() {
        filaPrioritaria = new Fila<>();
        filaNormal = new Fila<>();

        guichePreferencial = new AtendimentoPreferencial(filaPrioritaria, filaNormal);
        guicheGeral1 = new AtendimentoGeral("Geral 1", filaPrioritaria, filaNormal);
        guicheGeral2 = new AtendimentoGeral("Geral 2", filaPrioritaria, filaNormal);

        todosGuiches = new Guiche[]{ guichePreferencial, guicheGeral1, guicheGeral2 };

        relogio = 480; // 08:00
        random = new Random();
        proximoId = 1;
        guicheGeralVez = 0;

        relatorio = new Relatorio(todosGuiches);
    }

    // ═════════════════════════════════════════════════════════════════════════
    // MENU PRINCIPAL
    // ═════════════════════════════════════════════════════════════════════════

    /** Inicia o loop do menu de console. */
    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        boolean executando = true;

        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║       SIMULADOR DE ATENDIMENTO BANCÁRIO          ║");
        System.out.println("║   Estruturas de Dados — Fila, Pilha, Ordenação  ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        while (executando) {
            System.out.println();
            System.out.printf("  ⏰  Horário atual: %s%n",
                    RegistroAtendimento.formatarHorario(relogio));
            System.out.printf("  🔵 Fila Prioritária: %d cliente(s) | 🟡 Fila Normal: %d cliente(s)%n",
                    filaPrioritaria.tamanho(), filaNormal.tamanho());
            System.out.println();
            System.out.println("  ┌──────────────────────────────────────────┐");
            System.out.println("  │              MENU PRINCIPAL              │");
            System.out.println("  ├──────────────────────────────────────────┤");
            System.out.println("  │  1. Adicionar cliente PRIORITÁRIO        │");
            System.out.println("  │  2. Adicionar cliente NORMAL             │");
            System.out.println("  │  3. Adicionar N clientes aleatórios      │");
            System.out.println("  │  4. Chamar próximo — Guichê Preferencial │");
            System.out.println("  │  5. Chamar próximo — Guichê Geral 1      │");
            System.out.println("  │  6. Chamar próximo — Guichê Geral 2      │");
            System.out.println("  │  7. Chamar próximo — próximo geral livre │");
            System.out.println("  │  8. Atender todos (simular lote)         │");
            System.out.println("  │  9. Ver status das filas e históricos    │");
            System.out.println("  │  10. Avançar relógio (+ minutos)         │");
            System.out.println("  │  11. Gerar relatório final               │");
            System.out.println("  │  0. Sair                                 │");
            System.out.println("  └──────────────────────────────────────────┘");
            System.out.print("  Opção: ");

            int opcao = lerInteiro(sc, 0, 11);

            switch (opcao) {
                case 1:
                    adicionarCliente(sc, TipoCliente.PRIORITARIO);
                    break;
                case 2:
                    adicionarCliente(sc, TipoCliente.NORMAL);
                    break;
                case 3:
                    adicionarClientesAleatorios(sc);
                    break;
                case 4:
                    chamarGuiche(guichePreferencial);
                    break;
                case 5:
                    chamarGuiche(guicheGeral1);
                    break;
                case 6:
                    chamarGuiche(guicheGeral2);
                    break;
                case 7:
                    chamarProximoGuicheGeral();
                    break;
                case 8:
                    atenderTodos();
                    break;
                case 9:
                    exibirStatus();
                    break;
                case 10:
                    avancarRelogio(sc);
                    break;
                case 11:
                    relatorio.gerarRelatorio();
                    break;
                case 0:
                    executando = false;
                    System.out.println("\n  Encerrando simulação. Até logo!");
                    break;
            }
        }
        sc.close();
    }

    // ═════════════════════════════════════════════════════════════════════════
    // OPERAÇÕES DO SIMULADOR
    // ═════════════════════════════════════════════════════════════════════════

    /**
     * Adiciona um cliente manualmente à fila correta.
     *
     * @param sc    scanner para leitura de entrada
     * @param tipo  PRIORITARIO ou NORMAL
     */
    private void adicionarCliente(Scanner sc, TipoCliente tipo) {
        System.out.print("  Informe o tempo de atendimento (2-30 min) ou 0 para sortear: ");
        int tempo = lerInteiro(sc, 0, 30);
        if (tempo < 2) {
            tempo = 2 + random.nextInt(29); // sorteia entre 2 e 30
        }

        RegistroAtendimento cliente = new RegistroAtendimento(
                proximoId++, relogio, tempo, tipo);

        if (tipo == TipoCliente.PRIORITARIO) {
            filaPrioritaria.enqueue(cliente);
        } else {
            filaNormal.enqueue(cliente);
        }

        System.out.printf("%n  ✔ Cliente #%d [%s] adicionado à fila. Tempo de atendimento: %d min%n",
                cliente.getIdCliente(), tipo, tempo);
    }

    /**
     * Adiciona N clientes com tipo e tempo de atendimento aleatórios.
     *
     * @param sc scanner para leitura de entrada
     */
    private void adicionarClientesAleatorios(Scanner sc) {
        System.out.print("  Quantos clientes deseja adicionar? ");
        int qtd = lerInteiro(sc, 1, 1000);

        for (int i = 0; i < qtd; i++) {
            TipoCliente tipo = (random.nextInt(4) == 0) // ~25% prioritários
                    ? TipoCliente.PRIORITARIO
                    : TipoCliente.NORMAL;
            int tempo = 2 + random.nextInt(29);

            RegistroAtendimento cliente = new RegistroAtendimento(
                    proximoId++, relogio, tempo, tipo);

            if (tipo == TipoCliente.PRIORITARIO) {
                filaPrioritaria.enqueue(cliente);
            } else {
                filaNormal.enqueue(cliente);
            }
        }
        System.out.printf("%n  ✔ %d clientes adicionados.%n", qtd);
        System.out.printf("  Fila Prioritária: %d | Fila Normal: %d%n",
                filaPrioritaria.tamanho(), filaNormal.tamanho());
    }

    /**
     * Chama o próximo cliente em um guichê específico, atualizando o relógio.
     *
     * @param guiche guichê que vai realizar o atendimento
     */
    private void chamarGuiche(Guiche guiche) {
        guiche.setRelogio(relogio);
        RegistroAtendimento atendido = guiche.chamarProximo();

        if (atendido == null) {
            System.out.printf("%n  ⚠ Guichê [%s]: nenhum cliente nas filas.%n", guiche.getNome());
        } else {
            // Avança o relógio pelo tempo de atendimento
            relogio += atendido.getTempoAtendimento();
            System.out.printf("%n  ✔ Guichê [%s] atendeu o cliente #%d [%s]%n",
                    guiche.getNome(),
                    atendido.getIdCliente(),
                    atendido.getTipoCliente());
            System.out.printf("     Espera: %d min | Duração: %d min | Fim: %s%n",
                    atendido.getTempoEspera(),
                    atendido.getTempoAtendimento(),
                    RegistroAtendimento.formatarHorario(atendido.getHorarioFimAtendimento()));
        }
    }

    /**
     * Alterna entre Geral 1 e Geral 2 para o próximo atendimento.
     */
    private void chamarProximoGuicheGeral() {
        AtendimentoGeral[] gerais = { guicheGeral1, guicheGeral2 };
        AtendimentoGeral escolhido = gerais[guicheGeralVez % 2];
        guicheGeralVez++;
        chamarGuiche(escolhido);
    }

    /**
     * Atende todos os clientes das filas em lote, alternando entre os três guichês.
     */
    private void atenderTodos() {
        int atendidos = 0;
        Guiche[] sequencia = { guichePreferencial, guicheGeral1, guicheGeral2 };
        int vez = 0;

        while (!filaPrioritaria.vazia() || !filaNormal.vazia()) {
            Guiche g = sequencia[vez % 3];
            vez++;
            g.setRelogio(relogio);
            RegistroAtendimento r = g.chamarProximo();
            if (r != null) {
                relogio += r.getTempoAtendimento();
                atendidos++;
            }
        }
        System.out.printf("%n  ✔ Lote concluído: %d atendimentos realizados.%n", atendidos);
        System.out.printf("  Horário final: %s%n", RegistroAtendimento.formatarHorario(relogio));
    }

    /**
     * Exibe o estado atual das filas e o histórico de cada guichê.
     */
    private void exibirStatus() {
        System.out.println();
        System.out.println("  ── STATUS ATUAL ────────────────────────────────────────");
        System.out.printf("  Horário: %s%n", RegistroAtendimento.formatarHorario(relogio));
        System.out.printf("  Fila Prioritária: %d cliente(s)%n", filaPrioritaria.tamanho());
        System.out.printf("  Fila Normal     : %d cliente(s)%n", filaNormal.tamanho());
        System.out.println();
        System.out.println("  ── HISTÓRICO DOS GUICHÊS (topo da pilha = último atendido) ──");

        for (Guiche g : todosGuiches) {
            System.out.printf("%n  [%s] — %d atendimento(s)%n", g.getNome(), g.getTotalAtendimentos());
            RegistroAtendimento[] hist = g.getAtendimentosComoArray();
            if (hist.length == 0) {
                System.out.println("    (nenhum atendimento ainda)");
            } else {
                int limite = Math.min(hist.length, 5); // exibe até 5 mais recentes
                for (int i = 0; i < limite; i++) {
                    System.out.println("    " + hist[i]);
                }
                if (hist.length > 5) {
                    System.out.printf("    ... e mais %d registro(s).%n", hist.length - 5);
                }
            }
        }
    }

    /**
     * Avança o relógio da simulação em um número informado de minutos.
     *
     * @param sc scanner para leitura de entrada
     */
    private void avancarRelogio(Scanner sc) {
        System.out.print("  Quantos minutos deseja avançar? ");
        int min = lerInteiro(sc, 1, 999);
        relogio += min;
        System.out.printf("  Relógio avançado para %s.%n",
                RegistroAtendimento.formatarHorario(relogio));
    }

    // ─── Utilitário de leitura segura ─────────────────────────────────────────

    /**
     * Lê um inteiro do console dentro de um intervalo válido,
     * exibindo mensagem de erro em caso de entrada inválida.
     *
     * @param sc  scanner
     * @param min valor mínimo aceito
     * @param max valor máximo aceito
     * @return inteiro válido informado pelo usuário
     */
    private int lerInteiro(Scanner sc, int min, int max) {
        while (true) {
            try {
                int valor = Integer.parseInt(sc.nextLine().trim());
                if (valor >= min && valor <= max) return valor;
                System.out.printf("  Por favor, informe um número entre %d e %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("  Entrada inválida. Tente novamente: ");
            }
        }
    }
}
