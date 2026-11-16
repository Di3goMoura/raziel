package inicio.Interpretacao;

import java.text.Normalizer;
import java.util.Locale;

public class NormalizadorTexto {
    public static String normalizar(String texto) {
        texto = texto.toLowerCase(Locale.ROOT);
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("\\p{M}+", "");
        return texto;
    }
}
