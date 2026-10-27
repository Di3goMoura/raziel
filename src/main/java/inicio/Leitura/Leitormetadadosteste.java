package inicio.Leitura;

import inicio.Conhecimento.metadados;

import java.io.IOException;
import java.nio.file.Path;

public class Leitormetadadosteste {
    public static void main(String[] args) throws IOException {




        Path caminhoArquivo = Path.of("C:\\Raziel\\raziel\\vault\\01-conceitos\\Encapsulamento.md");
        leitorMetadados leitor = new leitorMetadados();
        metadados dadosnota = leitor.lermetadados(caminhoArquivo);
        System.out.println("ID: " + dadosnota.getId());
        System.out.println("titulo: " + dadosnota.getTitulo());
        System.out.println("Assunto: " + dadosnota.getAssunto());
        System.out.println("Palavras-chave: " + dadosnota.getPalavrasChave());

        }
    }

