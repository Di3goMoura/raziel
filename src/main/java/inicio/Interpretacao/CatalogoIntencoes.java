package inicio.Interpretacao;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CatalogoIntencoes {
    private final Path caminhoArquivo;
    private final Map<Intencao, List<String>> expressoes;

    public CatalogoIntencoes(Path caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
        this.expressoes = new HashMap<>();

    }

    public void carregarIntencoes() throws IOException {
        try (InputStream entrada = Files.newInputStream(caminhoArquivo)) {
            Yaml yaml = new Yaml();
            Map<String, List<String>> dados = yaml.load(entrada);
            for (Map.Entry<String, List<String>> entradaIntencao : dados.entrySet()) {
                String nomeIntencao = entradaIntencao.getKey();
                Intencao intencao = Intencao.valueOf(nomeIntencao);
                List<String> listaexpressoes = entradaIntencao.getValue();
                expressoes.put(intencao, listaexpressoes);

            }
        }

    }

    public Map<Intencao, List<String>> getExpressoes() {
        return expressoes;
    }
}
