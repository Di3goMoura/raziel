package inicio.Leitura;

import inicio.Conhecimento.metadados;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.yaml.snakeyaml.Yaml;

public class leitorMetadados {


    Yaml interpretador = new Yaml();

    public metadados lermetadados(Path caminhoArquivo) throws IOException {
        String conteudo = Files.readString(caminhoArquivo);
        int inicio = conteudo.indexOf("---");
        int fim = conteudo.indexOf("---", inicio + 3);
        if (inicio == -1 || fim == -1) {
            return null;

        }
        String yaml = conteudo.substring(inicio + 3, fim);
        Map<String, Object> dados = interpretador.load(yaml);
        String titulo = (String) dados.get("titulo");
        String id = (String) dados.get("id");
        String assunto = (String) dados.get("assunto");
        String categoria = (String) dados.get("categoria");
        List<String> palavrasChave = (List<String>) dados.get("palavrasChave");
        metadados metadados = new metadados(titulo, assunto, categoria, id, palavrasChave);

        return metadados;

    }
}
