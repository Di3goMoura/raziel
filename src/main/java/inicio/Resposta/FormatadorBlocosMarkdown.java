
package inicio.Resposta;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatadorBlocosMarkdown {

    private static final Pattern BLOCO = Pattern.compile(
            "(?m)^[ \\t]*```([^\\r\\n]*)\\R([\\s\\S]*?)^[ \\t]*```[ \\t]*$"
    );

    public static String formatar(String conteudo) {

        if (conteudo == null || conteudo.isEmpty()) {
            return "";
        }

        Matcher matcher = BLOCO.matcher(conteudo);
        StringBuilder resultado = new StringBuilder();

        while (matcher.find()) {

            String linguagem = matcher.group(1).trim();
            String codigo = matcher.group(2);

            if (linguagem.isEmpty()) {
                linguagem = "CODIGO";
            }

            String caixa = criarCaixa(
                    linguagem.toUpperCase(),
                    codigo
            );

            matcher.appendReplacement(
                    resultado,
                    Matcher.quoteReplacement(caixa)
            );
        }

        matcher.appendTail(resultado);

        return resultado.toString();
    }

    private static String criarCaixa(String linguagem, String codigo) {

        codigo = codigo.replaceFirst("\\R$", "");

        String[] linhas = codigo.split("\\R", -1);

        int largura = linguagem.length();

        for (String linha : linhas) {
            largura = Math.max(largura, linha.length());
        }

        StringBuilder caixa = new StringBuilder();

        caixa.append("┌")
                .append("─".repeat(largura + 2))
                .append("┐\n");

        caixa.append("│ ")
                .append(linguagem)
                .append(" ".repeat(largura - linguagem.length()))
                .append(" │\n");

        caixa.append("├")
                .append("─".repeat(largura + 2))
                .append("┤\n");

        for (String linha : linhas) {

            caixa.append("│ ")
                    .append(linha)
                    .append(" ".repeat(largura - linha.length()))
                    .append(" │\n");
        }

        caixa.append("└")
                .append("─".repeat(largura + 2))
                .append("┘");

        return caixa.toString();
    }
}
