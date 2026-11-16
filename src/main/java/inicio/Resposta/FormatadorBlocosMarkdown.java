
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

        int largura = String.valueOf(linhas.length).length();
        int larguraCodigo = linguagem.length();

        for (String linha : linhas) {
            larguraCodigo = Math.max(larguraCodigo, largura + 3 + linha.length());
        }

        StringBuilder caixa = new StringBuilder();

        caixa.append("┌")
                .append("─".repeat(larguraCodigo + 2))
                .append("┐\n");

        caixa.append("│ ")
                .append(linguagem)
                .append(" ".repeat(larguraCodigo - linguagem.length()))
                .append(" │\n");

        caixa.append("├")
                .append("─".repeat(larguraCodigo + 2))
                .append("┤\n");

        for (int i = 0; i < linhas.length; i++) {
            String numero = String.valueOf(i + 1);

            String linha = " ".repeat(largura - numero.length())
                    + numero
                    + " | "
                    + linhas[i];

            caixa.append("│ ")
                    .append(linha)
                    .append(" ".repeat(larguraCodigo - linha.length()))
                    .append(" │\n");
        }

        caixa.append("└")
                .append("─".repeat(larguraCodigo + 2))
                .append("┘");

        return caixa.toString();
    }
}
