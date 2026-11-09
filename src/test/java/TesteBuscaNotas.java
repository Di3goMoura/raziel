import inicio.Busca.LocalizadorNotas;
import inicio.Leitura.LeitorVault;
import inicio.Leitura.RegistroNotas;
import inicio.Leitura.RepositorioNotas;

import java.nio.file.Path;

public class TesteBuscaNotas {
    public static void main(String [] args){
        LeitorVault leitorVault1 = new LeitorVault( Path.of("C:\\Raziel\\raziel\\vault"));
        RepositorioNotas repositorioNotas  = new RepositorioNotas(Path.of("C:\\Raziel\\raziel\\vault"));
        repositorioNotas.carregarNotas(leitorVault1);
        LocalizadorNotas localizadorNotas = new LocalizadorNotas(repositorioNotas);
        localizadorNotas.indexNotas();
        RegistroNotas resultado = localizadorNotas.buscaPorId("java-poo-encapsulamento");
        if (resultado != null){
            System.out.println("anotaçao encontrada");
        }




    }
}
