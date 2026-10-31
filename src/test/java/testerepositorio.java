import inicio.Conhecimento.metadados;
import inicio.Leitura.LeitorVault;
import inicio.Leitura.RegistroNotas;
import inicio.Leitura.RepositorioNotas;

import java.nio.file.Path;

public class testerepositorio {
    public static void main (String[] args) {
        RepositorioNotas repositorio= new RepositorioNotas(Path.of("C:\\Raziel\\raziel\\vault" ));
       LeitorVault leitorVault = new LeitorVault(Path.of("C:\\Raziel\\raziel\\vault") );
       repositorio.carregarNotas(leitorVault);

       for (RegistroNotas registro : repositorio.getRegistros()){
           registro.getMetadados().getAssunto();
           System.out.println("titulo: " + registro.getMetadados().getAssunto());

       }

    }

    }


