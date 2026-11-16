package inicio.Interpretacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InterpretadorNivel {
    private final CatalogoNiveis catalogoNiveis;

    public InterpretadorNivel(CatalogoNiveis catalogoNiveis) {
        this.catalogoNiveis = catalogoNiveis;

    }

    public NivelConhecimento Consultar(String nivel) {
        String Nivelnormalizado = NormalizadorTexto.normalizar(nivel);
        for (Map.Entry<NivelConhecimento, List<String>> entrada : catalogoNiveis.getNiveis().entrySet()) {
            NivelConhecimento nivelConhecimento = entrada.getKey();
            List<String> niveis = entrada.getValue();
            for (String nsei : niveis) {
                String nivelNormalizado = NormalizadorTexto.normalizar(nsei);
                if (Nivelnormalizado.contains(nivelNormalizado)) {
                    return nivelConhecimento;
                }
            }

        }
        return NivelConhecimento.INICIANTE;
    }
}
