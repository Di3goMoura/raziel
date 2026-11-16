package inicio.Sala;

import inicio.Busca.LocalizadorNotas;
import inicio.Busca.ResultadoBusca;
import inicio.Busca.SelecionadorConteudo;
import inicio.Interpretacao.Intencao;
import inicio.Interpretacao.NivelConhecimento;
import inicio.Leitura.RegistroNotas;

import java.util.List;

public class SistemaBusca {

    LocalizadorNotas localizadorNotas;
    SelecionadorConteudo selecionadorConteudo;

    public SistemaBusca(LocalizadorNotas localizadorNotas, SelecionadorConteudo selecionadorConteudo) {
        this.localizadorNotas = localizadorNotas;
        this.selecionadorConteudo = selecionadorConteudo;

    }

    public String buscaConteudo(String id, List<Intencao> intencoes, NivelConhecimento nivel) {
        RegistroNotas nota = localizadorNotas.buscaPorId(id);
        if (nota == null) {
            return "nota nao encontrada";
        }
        return selecionadorConteudo.selecionarConteudo(nota, intencoes, nivel);
    }

    public void iniciarBusca() {
        localizadorNotas.indexNotas();
    }
}
