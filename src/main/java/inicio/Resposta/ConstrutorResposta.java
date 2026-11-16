package inicio.Resposta;

public class ConstrutorResposta {


    public String construtorResposta (String conteudo){
        StringBuilder cabecalho = new StringBuilder();
        cabecalho.append("========RAZIEL======== \n\n");
        cabecalho.append(FormatadorBlocosMarkdown.formatar(conteudo));
        cabecalho.append("\n\n===== Tenha um Bom Aprendizado!! ========== ");
        return cabecalho.toString();


    }
}