package inicio.Interpretacao;

import inicio.Leitura.RepositorioNotas;

import java.awt.*;
import java.text.Normalizer;


import static java.util.Collections.replaceAll;

public class InterpretadorAssunto {
    private final RepositorioNotas repositorioNotas;

    public InterpretadorAssunto (RepositorioNotas repositorioNotas){
        this.repositorioNotas = repositorioNotas;
    }

    public String normalizar (String texto){
    texto = texto.toLowerCase();
    String remocao = Normalizer.normalize(texto,Normalizer.Form.NFD);
        remocao = remocao.replaceAll("\\p{M}", "");
        return  remocao;


    }    private boolean corresponde(String pergunta, String termo) {
        termo = normalizar(termo);

        String regex = "(?<![\\p{L}\\p{N}])"
                + java.util.regex.Pattern.quote(termo)
                + "(?![\\p{L}\\p{N}])";

        return java.util.regex.Pattern
                .compile(regex)
                .matcher(pergunta)
                .find();
    }

    }



