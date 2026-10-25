package inicio.Conhecimento;

import java.util.ArrayList;
import java.util.List;

public class ConteudoConhecimento {
    private List<secaoConhecimento> secoes;

    public ConteudoConhecimento() {
        this.secoes = new ArrayList<>();


    }

    public void adicionarSecao(secaoConhecimento secao) {
        secoes.add(secao);
    }

    public List<secaoConhecimento> getSecoes() {
        return secoes;
    }
}
