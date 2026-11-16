package inicio.Leitura;

import inicio.Conhecimento.metadados;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RepositorioNotas {
    private Path caminhoVault;

    private List<RegistroNotas> registros;

    public RepositorioNotas(Path caminhoVault) {
        this.registros = new ArrayList<>();
        this.caminhoVault = caminhoVault;

    }

    public void carregarNotas(LeitorVault leitorVault) {
        List<Path> arquivosEncontrados = leitorVault.localizarArquivos();
        for (Path arquivo : arquivosEncontrados) {
            leitorMetadados leitorMetadados = new leitorMetadados();
            try {
                metadados metadadosNota = leitorMetadados.lermetadados(arquivo);
                if (metadadosNota == null){
                    continue;
                }
                RegistroNotas registro = new RegistroNotas(arquivo, metadadosNota);
                registros.add(registro);

            } catch (IOException e) {
                System.out.println("nao foi possivel executar essa açao" + arquivo);
            }

        }
        System.out.println("quantidade imprimida: " + registros.size());
    }

    public List<RegistroNotas> getRegistros() {
        return registros;

    }

}
