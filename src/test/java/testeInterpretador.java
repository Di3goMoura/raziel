import inicio.Interpretacao.CatalogoIntencoes;
import inicio.Interpretacao.Intencao;
import inicio.Interpretacao.InterpretadorIntencao;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class testeInterpretador {
    public static void main (String [] args) throws IOException {

      CatalogoIntencoes catalogoIntencoes = new CatalogoIntencoes(Path.of("C:\\Raziel\\raziel\\vault\\intençoes\\intençoes.md"));
      catalogoIntencoes.carregarIntencoes();

      InterpretadorIntencao interpretadorIntencao = new InterpretadorIntencao(catalogoIntencoes);
        List<Intencao> intencoesEncontradas = interpretadorIntencao.interpretar("Quero um contraexemplo de encapsulamento");
      System.out.println(intencoesEncontradas);
      }

      }


