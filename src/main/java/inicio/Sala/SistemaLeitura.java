package inicio.Sala;

import inicio.Leitura.LeitorVault;
import inicio.Leitura.RegistroNotas;
import inicio.Leitura.RepositorioNotas;

import java.nio.file.Path;
import java.util.List;

public class SistemaLeitura {
    LeitorVault leitorVault;
    RepositorioNotas repositorioNotas;

    public  SistemaLeitura(Path camimhoVault){
       LeitorVault leitorVault = new LeitorVault(camimhoVault);
       this.leitorVault = leitorVault;
       this.repositorioNotas = new RepositorioNotas(camimhoVault);
       }
       public void iniciarLeitura(){
        repositorioNotas.carregarNotas(leitorVault);

       } public List<RegistroNotas> getRegistros(){
      return   repositorioNotas.getRegistros();

    }
    }
