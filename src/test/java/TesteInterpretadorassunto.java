

import inicio.Leitura.LeitorVault;
import inicio.Leitura.RepositorioNotas;
import inicio.Interpretacao.InterpretadorAssunto;

import java.nio.file.Path;
import java.util.List;

public class TesteInterpretadorassunto {

    public static void main(String[] args) {

        // 1. Caminho do Vault do Obsidian
        Path caminhoVault = Path.of("C:\\Raziel\\raziel\\vault");

        // 2. Criar o leitor do Vault
        LeitorVault leitorVault = new LeitorVault(caminhoVault);

        // 3. Criar o repositório
        RepositorioNotas repositorioNotas = new RepositorioNotas(caminhoVault);

        // 4. Carregar as anotações
        repositorioNotas.carregarNotas(leitorVault);

        // 5. Criar o interpretador de assuntos
        InterpretadorAssunto interpretador =
                new InterpretadorAssunto(repositorioNotas);

        // 6. Fazer uma pergunta
        String pergunta = "COMO FUNCIONA ENCAPSULAMENTO";

        // 7. Interpretar a pergunta
        List<String> idsEncontrados = interpretador.interpretador(pergunta);

        // 8. Mostrar o resultado
        System.out.println("Pergunta: " + pergunta);
        System.out.println("IDs encontrados: " + idsEncontrados);
    }
}