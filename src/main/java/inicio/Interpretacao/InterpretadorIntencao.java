package inicio.Interpretacao;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InterpretadorIntencao {
    private final CatalogoIntencoes catalogoIntencoes;

    public InterpretadorIntencao(CatalogoIntencoes catalogoIntencoes) {
        this.catalogoIntencoes = catalogoIntencoes;

    }

    public List<Intencao> interpretar(String pergunta) {
        String perguntanormalizada = NormalizadorTexto.normalizar(pergunta);
        List<Intencao> intençoesEncontradas = new ArrayList<>();
        for (Map.Entry<Intencao, List<String>> entrada :
                catalogoIntencoes.getExpressoes().entrySet()) {
            Intencao intencao = entrada.getKey();
            List<String> espressoes = entrada.getValue();
            for (String expresao : espressoes) {
                String expressaoNormalizada = NormalizadorTexto.normalizar(expresao);
                if (perguntanormalizada.contains(expressaoNormalizada)) {
                    intençoesEncontradas.add(intencao);

                    break;



                }
            }

    }
        return intençoesEncontradas;
}
    }