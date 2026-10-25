package inicio.Conhecimento;

import java.util.ArrayList;
import java.util.List;

public class metadados {
    private final String id;
    private String titulo;
    private String assunto;
    private String categoria;
    private List<String> palavrasChave;

    public metadados(String titulo, String assunto, String categoria, String id, List<String> palavrasChave) {
        this.titulo = titulo;
        this.assunto = assunto;
        this.categoria = categoria;
        this.id = id;
        this.palavrasChave = palavrasChave;

    }

    public String getId() {
        return id;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;

    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto( String assunto) {
        this.assunto = assunto;
    }

    public String getCategoria(){
        return categoria;

    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public List<String>getPalavrasChave(){
        return palavrasChave;

    }public void setPalavrasChave(List<String> palavrasChave){
        this.palavrasChave = palavrasChave;
    }
}

