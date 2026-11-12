package inicio.Sala;

import inicio.Resposta.ConstrutorResposta;

public class SistemaResposta {

    ConstrutorResposta construtorResposta;

    public SistemaResposta(ConstrutorResposta construtorResposta){
        this.construtorResposta =construtorResposta;

    }public String resposta(String resposta){
     return    construtorResposta.construtorResposta(resposta);
    }
}
