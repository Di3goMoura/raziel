package inicio.Conhecimento;

public class NotaConhecimento {

    private metadados metadadosNotas;
    private ConteudoConhecimento conteudoConhecimento;

    public NotaConhecimento(metadados metadadosNotas, ConteudoConhecimento conteudoConhecimento) {
        this.metadadosNotas = metadadosNotas;
        this.conteudoConhecimento = conteudoConhecimento;

    }

    public metadados getMetadadosNotas() {
        return metadadosNotas;

    }

    public ConteudoConhecimento getConteudoConhecimento() {
        return conteudoConhecimento;
    }

}