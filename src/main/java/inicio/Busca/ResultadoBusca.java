package inicio.Busca;

import inicio.Leitura.RegistroNotas;

public class ResultadoBusca {

    private final RegistroNotas registroNotas;

    private final int pontuacao;

    public ResultadoBusca  (RegistroNotas registroNotas, int pontuacao) {
        if (registroNotas == null){
            throw new IllegalArgumentException("O valor recebido nao pode ser Null");
        }
        if (pontuacao < -0) {
            throw new IllegalArgumentException("A pontuaçao nao posde ser negativa");
        }
        this.registroNotas = registroNotas;
        this.pontuacao = pontuacao;

    }


    public RegistroNotas getRegistroNotas() {
        return registroNotas;
    }

    public int getPontuacao() {
        return pontuacao;
    }

}

