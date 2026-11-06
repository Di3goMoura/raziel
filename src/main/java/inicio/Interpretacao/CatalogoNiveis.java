package inicio.Interpretacao;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatalogoNiveis {
    private final Path caminhoArquivo;
    private final Map<NivelConhecimento, List<String> > niveis;

    public CatalogoNiveis(Path caminhoArquivo){
        this.caminhoArquivo = caminhoArquivo;
        this.niveis = new HashMap<>();


    } public void carregarNiveis() throws IOException{
        try (InputStream entrada = Files.newInputStream(caminhoArquivo)) {
            Yaml yaml = new Yaml();
            Map<String, List<String>> informacoes = yaml.load(entrada);
            for (Map.Entry<String, List<String>> entradaNivel : informacoes.entrySet()){
                String nivel =  entradaNivel.getKey();
                NivelConhecimento nivelConhecimento = NivelConhecimento.valueOf(nivel);
                List<String> listaNiveis = entradaNivel.getValue();
                niveis.put(nivelConhecimento, listaNiveis );
            }

        }

    } public Map<NivelConhecimento, List<String>> getNiveis(){
        return niveis;
    }
}
