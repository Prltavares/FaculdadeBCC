package modelo;

/**
 * Representa um registro completo de atendimento de um cliente no banco.
 * Contém todos os dados necessários para rastreamento e geração de relatórios.
 */
public class RegistroAtendimento {

    /** Tipos possíveis de cliente */
    public enum TipoCliente {
        PRIORITARIO, NORMAL
    }

    private final int idCliente;
    private final int horarioChegada;       // em minutos desde abertura do banco
    private final int tempoAtendimento;     // duração do atendimento (2-30 min)
    private final TipoCliente tipoCliente;

    private int horarioInicioAtendimento;   // quando o guichê chamou o cliente
    private int horarioFimAtendimento;      // horarioInicio + tempoAtendimento
    private int tempoEspera;                // horarioInicio - horarioChegada
    private String nomeGuiche;              // guichê que atendeu este cliente

    /**
     * Constrói um novo registro de atendimento para um cliente que acabou de chegar.
     *
     * @param idCliente        identificador único do cliente
     * @param horarioChegada   minuto de chegada na fila
     * @param tempoAtendimento duração prevista do atendimento (2-30 min)
     * @param tipoCliente      PRIORITARIO ou NORMAL
     */
    public RegistroAtendimento(int idCliente, int horarioChegada,
                               int tempoAtendimento, TipoCliente tipoCliente) {
        this.idCliente = idCliente;
        this.horarioChegada = horarioChegada;
        this.tempoAtendimento = tempoAtendimento;
        this.tipoCliente = tipoCliente;
        this.horarioInicioAtendimento = -1; // ainda não atendido
        this.horarioFimAtendimento = -1;
        this.tempoEspera = -1;
        this.nomeGuiche = "";
    }

    // ─── Getters ───────────────────────────────────────────────────────────────

    public int getIdCliente()              { return idCliente; }
    public int getHorarioChegada()         { return horarioChegada; }
    public int getTempoAtendimento()       { return tempoAtendimento; }
    public TipoCliente getTipoCliente()    { return tipoCliente; }
    public int getHorarioInicioAtendimento() { return horarioInicioAtendimento; }
    public int getHorarioFimAtendimento()  { return horarioFimAtendimento; }
    public int getTempoEspera()            { return tempoEspera; }
    public String getNomeGuiche()          { return nomeGuiche; }

    // ─── Setters (usados apenas durante o processo de atendimento) ─────────────

    /**
     * Registra o início do atendimento e calcula automaticamente tempo de espera e fim.
     *
     * @param horarioInicio minuto em que o guichê chamou o cliente
     * @param guiche        nome do guichê responsável
     */
    public void iniciarAtendimento(int horarioInicio, String guiche) {
        this.horarioInicioAtendimento = horarioInicio;
        this.horarioFimAtendimento = horarioInicio + tempoAtendimento;
        this.tempoEspera = horarioInicio - horarioChegada;
        this.nomeGuiche = guiche;
    }

    /**
     * Retorna uma representação formatada em hh:mm de um valor em minutos.
     *
     * @param minutos valor em minutos desde 00:00
     * @return string no formato "hh:mm"
     */
    public static String formatarHorario(int minutos) {
        int h = minutos / 60;
        int m = minutos % 60;
        return String.format("%02d:%02d", h, m);
    }

    @Override
    public String toString() {
        if (horarioInicioAtendimento == -1) {
            return String.format("Cliente #%d [%s] | Chegada: %s | Aguardando",
                    idCliente, tipoCliente,
                    formatarHorario(horarioChegada));
        }
        return String.format(
                "Cliente #%d [%s] | Chegada: %s | Início: %s | Fim: %s | Espera: %d min | Guichê: %s",
                idCliente,
                tipoCliente,
                formatarHorario(horarioChegada),
                formatarHorario(horarioInicioAtendimento),
                formatarHorario(horarioFimAtendimento),
                tempoEspera,
                nomeGuiche);
    }
}
