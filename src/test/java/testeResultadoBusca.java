import inicio.Busca.ResultadoBusca;
import inicio.Conhecimento.metadados;
import inicio.Leitura.RegistroNotas;

import java.nio.file.Path;
import java.util.List;

public class testeResultadoBusca {
    public static  void main (String [] args){

        RegistroNotas registroNotas = new RegistroNotas(Path.of("C:\\Raziel\\raziel\\vault" ), new metadados("Encapsulamento" ,
                "Programação Orientada a Objetos" ,"conceito" , "java-poo-encapsulamento" , List.of("encapsulamento")));

        ResultadoBusca resultadoBusca = new ResultadoBusca(registroNotas, 1);
        System.out.println("Receba: " +resultadoBusca.getPontuacao());

    }
    }



