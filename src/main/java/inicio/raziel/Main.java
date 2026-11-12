package inicio.raziel;


import inicio.Busca.LocalizadorNotas;
import inicio.Busca.SelecionadorConteudo;
import inicio.Interpretacao.*;
import inicio.Leitura.RegistroNotas;
import inicio.Leitura.RepositorioNotas;
import inicio.Resposta.ConstrutorResposta;
import inicio.Sala.*;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        Path caminhoVault = Path.of("C:\\Raziel\\raziel\\vault");
        RepositorioNotas repositorio = new RepositorioNotas(caminhoVault);
        SistemaLeitura sistemaLeitura = new SistemaLeitura(caminhoVault, repositorio);
        CatalogoIntencoes catalogoIntencoes = new CatalogoIntencoes(caminhoVault.resolve("C:\\Raziel\\raziel\\vault\\intençoes\\intençoes.md"));
       try {
           catalogoIntencoes.carregarIntencoes();
       } catch (IOException e){
           System.out.println("erro ao carregar intençoes: " +e.getMessage());
           return;
       }
        CatalogoNiveis catalogoNiveis = new CatalogoNiveis(caminhoVault.resolve("C:\\Raziel\\raziel\\vault\\CatalogoNiveis\\Niveis.md"));
       try {
           catalogoNiveis.carregarNiveis();
       }catch (IOException e){
           System.out.println("erro ao carregar os niveis");
           return;
       }
        InterpretadorIntencao interpretadorIntencao = new InterpretadorIntencao(catalogoIntencoes);
        InterpretadorNivel interpretadorNivel = new InterpretadorNivel(catalogoNiveis);
        InterpretadorAssunto interpretadorAssunto = new InterpretadorAssunto(repositorio);
        SistemaInterpretacao sistemaInterpretacao = new SistemaInterpretacao(interpretadorNivel, interpretadorIntencao, interpretadorAssunto);

        LocalizadorNotas localizadorNotas = new LocalizadorNotas(repositorio);
        SelecionadorConteudo selecionadorConteudo = new SelecionadorConteudo();
        SistemaBusca sistemaBusca = new SistemaBusca(localizadorNotas, selecionadorConteudo);
        ConstrutorResposta construtorResposta = new ConstrutorResposta();
        SistemaResposta sistemaResposta = new SistemaResposta(construtorResposta);
        CentralComando centralComando = new CentralComando(sistemaLeitura, sistemaInterpretacao, sistemaBusca,sistemaResposta);
        CiclodeVida ciclodeVida = new CiclodeVida();
        InterfaceTerminal interfaceTerminal = new InterfaceTerminal(centralComando, ciclodeVida);
        interfaceTerminal.Iniciar();



    }
}