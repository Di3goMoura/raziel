
package inicio.Busca;

import inicio.Interpretacao.Intencao;
import inicio.Interpretacao.NivelConhecimento;
import inicio.Leitura.RegistroNotas;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SelecionadorConteudo {

    public String selecionarConteudo(
            RegistroNotas registroNotas,
            List<Intencao> intencaos,
            NivelConhecimento nivelConhecimento) {

        Path caminhoarquivo = registroNotas.getCaminhoarquivo();

        try {
            String conteudo = Files.readString(caminhoarquivo);
            String[] linhas = conteudo.split("\n");

            boolean dentroDaSecao = false;
            boolean dentroNivel = false;
            StringBuilder conteudoSelecionado = new StringBuilder();

            if (!intencaos.isEmpty()) {

                Intencao intencao = intencaos.get(0);
                String tituloProcurado = "";
                String tituloNivel = "";
                if (nivelConhecimento == NivelConhecimento.INICIANTE){
                    tituloNivel = "### Iniciante";
                }  else if (nivelConhecimento == NivelConhecimento.INTERMEDIARIO){
                    tituloNivel = "### Intermediário";
                } else if (nivelConhecimento == NivelConhecimento.AVANCADO){
                    tituloNivel = "### Avançado";
                }

                if (intencao == Intencao.EXPLICACAO) {
                    tituloProcurado = "## Explicacao";

                } else if (intencao == Intencao.EXEMPLO) {
                    tituloProcurado = "## Exemplo";

                } else if (intencao == Intencao.IMPLEMENTACAO) {
                    tituloProcurado = "## Implementacao";

                } else if (intencao == Intencao.PRATICA) {
                    tituloProcurado = "## Pratica";

                } else if (intencao == Intencao.COMPARACAO) {
                    tituloProcurado = "## Comparacao";

                } else if (intencao == Intencao.RESUMO) {
                    tituloProcurado = "## Resumo";

                } else if (intencao == Intencao.APLICACAO) {
                    tituloProcurado = "## Aplicacao";
                }
                for (String linha : linhas) {

                    if (linha.startsWith("## ")) {

                        if (linha.equals(tituloProcurado)) {
                            dentroDaSecao = true;
                        } else {
                            dentroDaSecao = false;
                        }
                    }else if (linha.startsWith("### ")){
                        dentroNivel = linha.equals(tituloNivel);

                    } else {

                        if (dentroDaSecao && dentroNivel) {
                            conteudoSelecionado
                                    .append(linha)
                                    .append("\n");
                        }
                    }
                }
            }

            return conteudoSelecionado.toString();

        } catch (IOException e) {
            throw new UncheckedIOException(
                    "Erro ao ler a anotação", e);
        }
    }
}
