import inicio.Interpretacao.CatalogoIntencoes;
import inicio.Interpretacao.Intencao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Testecatalogointencoes {
    public static void main(String[] args) throws IOException {
        CatalogoIntencoes catalogoIntencoes = new CatalogoIntencoes(Path.of("C:\\Raziel\\raziel\\vault\\intençoes\\intençoes.md"));


        catalogoIntencoes.carregarIntencoes();
        System.out.println(catalogoIntencoes.getExpressoes().get(Intencao.EXEMPLO));


    }
}
