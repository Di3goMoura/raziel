import inicio.Interpretacao.CatalogoNiveis;
import inicio.Interpretacao.InterpretadorNivel;
import inicio.Interpretacao.NivelConhecimento;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class TesteNivel {
    public static void main (String [] args) throws IOException {
        CatalogoNiveis catalogoNiveis = new CatalogoNiveis(Path.of("C:\\Raziel\\raziel\\vault\\CatalogoNiveis\\Niveis.md"));
        catalogoNiveis.carregarNiveis();

        InterpretadorNivel interpretadorNivel = new InterpretadorNivel(catalogoNiveis);
     NivelConhecimento teste =  interpretadorNivel.Consultar("NIVEL avançado e com mais detalhes ");
        System.out.println(teste);

    }
}
