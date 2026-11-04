package inicio.Leitura;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LeitorVault {

    private Path caminhovault;

    public LeitorVault(Path caminhoVault) {
        this.caminhovault = caminhoVault;

    }

    public List<Path> localizarArquivos() {
        List<Path> caminhos = new ArrayList<>();
        try (var arquivos = Files.walk(caminhovault)) {
            arquivos
                    .filter(Files::isRegularFile)
                    .filter(arquivo -> arquivo.toString().endsWith(".md"))
                    .forEach(arquivo -> caminhos.add(arquivo));
        } catch (IOException e) {
            throw new UncheckedIOException("Erro ao ler o vault", e);
        }
        return caminhos;


    }

    public Path getCaminhovault() {
        return caminhovault;
    }
}
