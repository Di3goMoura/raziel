package inicio.Sala;

import inicio.Leitura.LeitorPastas;
import inicio.Leitura.LeitorVault;
import inicio.Leitura.RegistroNotas;
import inicio.Leitura.RepositorioNotas;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SistemaLeitura {
    LeitorVault leitorVault;
    RepositorioNotas repositorioNotas;
    LeitorPastas leitorPastas;

    public SistemaLeitura(Path camimhoVault, RepositorioNotas repositorioNotas) {
        LeitorVault leitorVault = new LeitorVault(camimhoVault);
        this.leitorVault = leitorVault;
        this.repositorioNotas = repositorioNotas;
    }

    public void iniciarLeitura() {
        repositorioNotas.carregarNotas(leitorVault);

    }

    public List<RegistroNotas> getRegistros() {
        return repositorioNotas.getRegistros();

    } public List<Path> proejtos(){
        List<Path>recebeProjetos = leitorPastas.localizadorProjetos();
        List <Path> projetosguadados = new ArrayList<>();
        recebeProjetos.forEach(path -> {
            projetosguadados.addAll(leitorPastas.localizadorClasses(path));
        });
        return projetosguadados;


        }
    }

