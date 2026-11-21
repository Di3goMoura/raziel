package inicio.Sala;

import inicio.Interpretacao.InterpretadorProjetos;
import inicio.Leitura.LeitorPastas;
import inicio.Leitura.RepositorioProjetos;

import java.nio.file.Path;

public class SistemaProjeto {
    Path caminhoProjeto = Path.of("C:\\Kamehameha\\PROJETOS");
    LeitorPastas leitorPastas = new LeitorPastas(caminhoProjeto);
    RepositorioProjetos repositorioProjetos = new RepositorioProjetos();
    InterpretadorProjetos interpretadorProjetos = new InterpretadorProjetos(repositorioProjetos);



    public SistemaProjeto (){
        repositorioProjetos.armazenarprojetos(leitorPastas);

    } public InterpretadorProjetos ChamaProjetos(){
        return interpretadorProjetos;

    }

}


