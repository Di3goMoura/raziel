package inicio.Interpretacao;

import inicio.Leitura.RepositorioProjetos;
import inicio.Sala.EstadoRaziel;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class InterpretadorProjetos {
    private final RepositorioProjetos repositorioProjetos;

    private Path ProjetoAtual;
    private Path classeAtual;
    private EstadoNavegacao estado = EstadoNavegacao.PROJETOS;
    private boolean navegando = false;

    public enum EstadoNavegacao {
        PROJETOS,
        CLASSES,
        CODIGO
    } public boolean estaNavegando() {
        return navegando;
    }

    private EstadoNavegacao estadot = EstadoNavegacao.PROJETOS;


    public InterpretadorProjetos(RepositorioProjetos repositorioProjetos) {
        this.repositorioProjetos = repositorioProjetos;

    }

    public void interpretar(String pergunta) {
        if (pergunta.equalsIgnoreCase("voltar")) {
            estado = EstadoNavegacao.PROJETOS;
            navegando = false;
            return;
        }
        switch (estado) {
            case PROJETOS -> {
                if (pergunta.equals("Meus Projetos")) {
                    repositorioProjetos.listarprojetos();
                    navegando = true;

                }
                for (Path atual : repositorioProjetos.getProjetos()){


                    if (atual.getFileName().toString().equals(pergunta)) {
                        ProjetoAtual = atual;
                        estado = EstadoNavegacao.CLASSES;
                        repositorioProjetos.listarClasses(ProjetoAtual);
                    }
                    }


            } case CLASSES -> {

                    repositorioProjetos.listarClasses(ProjetoAtual);

            for (Path classe : repositorioProjetos.getClasssProjetoes(ProjetoAtual)){
              if ( classe.getFileName().toString().equals(pergunta)){
                   classeAtual = classe;
                   estado = EstadoNavegacao.CODIGO;
                  repositorioProjetos.listarcodigo(classeAtual);

              }
            }

            }case CODIGO -> {
                repositorioProjetos.listarcodigo(classeAtual);

            }

    }
}
    }



