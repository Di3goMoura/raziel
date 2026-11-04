package inicio.Interpretacao;

import inicio.Conhecimento.metadados;
import inicio.Leitura.RegistroNotas;
import inicio.Leitura.RepositorioNotas;

import java.awt.*;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import static java.util.Collections.replaceAll;

public class InterpretadorAssunto {
    private final RepositorioNotas repositorioNotas;

    public InterpretadorAssunto(RepositorioNotas repositorioNotas) {
        this.repositorioNotas = repositorioNotas;
    }

    public String normalizar(String texto) {
        texto = texto.toLowerCase();
        String remocao = Normalizer.normalize(texto, Normalizer.Form.NFD);
        remocao = remocao.replaceAll("\\p{M}", "");
        return remocao;


    }

    private boolean corresponde(String pergunta, String termo) {
        termo = normalizar(termo);

        String regex = "(?<![\\p{L}\\p{N}])"
                + java.util.regex.Pattern.quote(termo)
                + "(?![\\p{L}\\p{N}])";

        return java.util.regex.Pattern
                .compile(regex)
                .matcher(pergunta)
                .find();
    }

    private boolean correspondeEspecifico(
            String pergunta, metadados dados) {
        boolean encontrouTitulo = corresponde(pergunta, dados.getTitulo());
        boolean encontrouId = corresponde(pergunta, dados.getId());

        boolean encontroupalavara = false;

        for (String palavra : dados.getPalavrasChave()) {

                if (corresponde(pergunta, palavra)){
                    encontroupalavara = true;
                }
            }
        return encontrouTitulo || encontrouId || encontroupalavara;
        } public List<String> interpretador (String pergunta){
       String  perguntaNormalizada = normalizar(pergunta);
       List<String> idsEncontrados = new ArrayList<>();
       for (RegistroNotas registro : repositorioNotas.getRegistros()){
           metadados dados = registro.getMetadados();
           boolean encontrou = correspondeEspecifico(perguntaNormalizada, dados);
           if (encontrou){
               idsEncontrados.add(dados.getId());
           }


       }


        return idsEncontrados;
    }

    }




