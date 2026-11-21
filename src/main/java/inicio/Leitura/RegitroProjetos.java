package inicio.Leitura;

import java.nio.file.Path;
import java.util.List;

public class RegitroProjetos {
    private Path caminhoPasta;


    public RegitroProjetos (Path caminhoPasta){
        this.caminhoPasta = caminhoPasta;


    } public Path getCaminhoPasta() {
        return caminhoPasta;

    }
}
