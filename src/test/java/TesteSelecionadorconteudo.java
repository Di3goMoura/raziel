import inicio.Busca.SelecionadorConteudo;
import inicio.Interpretacao.Intencao;
import inicio.Interpretacao.NivelConhecimento;
import inicio.Leitura.RegistroNotas;
import inicio.Resposta.ConstrutorResposta;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TesteSelecionadorconteudo {
    public static void main(String [] args){
        ConstrutorResposta construtorResposta = new ConstrutorResposta();

        SelecionadorConteudo selecionadorConteudo = new SelecionadorConteudo();
        RegistroNotas registroNotas = new RegistroNotas( Path.of("C:\\Raziel\\raziel\\vault\\01-conceitos\\Encapsulamento.md"), null);
        List<Intencao> intençoes = List.of(Intencao.COMPARACAO);
        NivelConhecimento nivel = NivelConhecimento.INTERMEDIARIO;
        System.out.println("arquivo existe: " + Files.exists(Path.of("C:\\Raziel\\raziel\\vault\\01-conceitos\\Encapsulamento.md")));
        System.out.println("É um arquivo: " + Files.isRegularFile(Path.of("C:\\Raziel\\raziel\\vault\\01-conceitos\\Encapsulamento.md")));
        String resultado = selecionadorConteudo.selecionarConteudo(
                registroNotas,
                intençoes,
                nivel
        );  System.out.println( construtorResposta.construtorResposta(resultado));
    }
}
