package inicio.Conhecimento;

public class NotaConhecimento {

    private final String id;
    private String titulo;
    private String assunto;
    private String categoria;;
    private ConteudoConhecimento conteudoConhecimento;

    public NotaConhecimento (String id, String titulo, String assunto, String categoria, ConteudoConhecimento conteudoConhecimento){
        this.id = id;
        this.titulo = titulo;
        this.assunto = assunto;
        this.categoria = categoria;
        this.conteudoConhecimento = conteudoConhecimento;

     }public String getId() {
        return getId();

    }public String getTitulo() {
        return  getTitulo();
    }public String setTitulo(){
        return titulo;

    }public String getAssunto(){
        return assunto;
    }public String setAssunto(){
        return assunto;

    }public String getCategoria(){
        return categoria;
    }public String setCategoria(){
        return  categoria;

    }public ConteudoConhecimento getConteudoConhecimento(){
        return conteudoConhecimento;
    }public ConteudoConhecimento setConteudoconhecimento(){
        return conteudoConhecimento;
    }

}
