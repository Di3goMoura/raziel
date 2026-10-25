package inicio.Conhecimento;


import java.util.HashMap;
import java.util.Map;

public class secaoConhecimento {

    private final String id;
    private String titulo;
    private Map<NivelConhecimento, String> conteudoPorNivel;

    public secaoConhecimento(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.conteudoPorNivel = new HashMap<>();

    }

    public void adicionarConteudo(NivelConhecimento nivel, String explicacao) {
        conteudoPorNivel.put(nivel, explicacao);
    }

    public String obterConteudo(NivelConhecimento nivel) {
        return conteudoPorNivel.get(nivel);

    }

    public String getTitulo() {
        return titulo;
    }

    public String getId() {
        return id;
    }

    public String setTitulo(){
        return titulo;
    }

}