package inicio.Sala;

import java.util.concurrent.TimeUnit;

public class CiclodeVida {
    private static final long Tempo_LIMITE = 300_000;
    private EstadoRaziel estadoRaziel;
    private long ultimaIteraacao;

    public CiclodeVida() {
        this.estadoRaziel = EstadoRaziel.INICIANDO;

    }

    public EstadoRaziel getEstadoAtual() {
        return estadoRaziel;
    }

    public void ativar() {
        this.estadoRaziel = EstadoRaziel.ATIVO;
        registarInteracao();

    }

    public void Encerrar() {
        this.estadoRaziel = EstadoRaziel.ENCERRADO;
        System.out.println("Estou encerrando neste momento, Ate a proxima!");


    }

    public void registarInteracao() {
        ultimaIteraacao = System.nanoTime();
    }

    public boolean tempoEsgotado() {
        long tempoPassado = System.nanoTime() - ultimaIteraacao;
        long limiteEmnonos = TimeUnit.MILLISECONDS.toNanos(Tempo_LIMITE);
        return tempoPassado >= limiteEmnonos;
    }

    public boolean estaAtivo() {
        return estadoRaziel == EstadoRaziel.ATIVO;
    }

}






