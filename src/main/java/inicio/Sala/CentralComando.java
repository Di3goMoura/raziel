package inicio.Sala;

import inicio.Interpretacao.Intencao;
import inicio.Interpretacao.NivelConhecimento;

import java.util.List;

public class CentralComando {
    SistemaLeitura sistemaLeitura;
    SistemaInterpretacao sistemaInterpretacao;
    SistemaBusca sistemaBusca;
    SistemaResposta sistemaResposta;

    public CentralComando(SistemaLeitura sistemaLeitura, SistemaInterpretacao sistemaInterpretacao, SistemaBusca sistemaBusca,
                          SistemaResposta sistemaResposta) {
        this.sistemaLeitura = sistemaLeitura;
        this.sistemaInterpretacao = sistemaInterpretacao;
        this.sistemaBusca = sistemaBusca;
        this.sistemaResposta = sistemaResposta;

    }

    public void ligar() {
        sistemaLeitura.iniciarLeitura();
        sistemaBusca.iniciarBusca();

    }

    public String processarPergunta(String pergunta) {
        NivelConhecimento nivel = sistemaInterpretacao.interpretarNivel(pergunta);

        List<Intencao> intencoes = sistemaInterpretacao.interpretadorIntencao(pergunta);
        System.out.println("DEBUG - Intenções encontradas: " + intencoes);

        List<String> assuntos = sistemaInterpretacao.interpretarAssunto(pergunta);

        if (assuntos.isEmpty()) {
            return "Nao encontrei esse assunto nas minhas anotaçoes";

        } if (intencoes.isEmpty()){
            intencoes =List.of(Intencao.EXPLICACAO);
        }
        String id = assuntos.get(0);
        String conteudo = sistemaBusca.buscaConteudo( id, intencoes, nivel );

        return sistemaResposta.resposta(conteudo);
    }
}

