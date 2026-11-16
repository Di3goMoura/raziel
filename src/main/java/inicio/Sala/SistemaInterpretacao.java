package inicio.Sala;

import inicio.Interpretacao.*;

import java.util.ArrayList;
import java.util.List;

public class SistemaInterpretacao {

    InterpretadorNivel interpretadorNivel;
    InterpretadorIntencao interpretadorIntencao;
    InterpretadorAssunto interpretadorAssunto;

    public SistemaInterpretacao(InterpretadorNivel interpretadorNivel, InterpretadorIntencao interpretadorIntencao,
                                InterpretadorAssunto interpretadorAssunto) {
        this.interpretadorNivel = interpretadorNivel;
        this.interpretadorIntencao = interpretadorIntencao;
        this.interpretadorAssunto = interpretadorAssunto;


    }

    public List<String> interpretarAssunto(String pergunta) {
        return interpretadorAssunto.interpretador(pergunta);

    }

    public List<Intencao> interpretadorIntencao(String pergunta) {
        return interpretadorIntencao.interpretar(pergunta);

    }

    public NivelConhecimento interpretarNivel(String pergunta) {
        return interpretadorNivel.Consultar(pergunta);


    }
}
