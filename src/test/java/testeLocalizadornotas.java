import inicio.Busca.LocalizadorNotas;
import inicio.Leitura.LeitorVault;
import inicio.Leitura.RegistroNotas;
import inicio.Leitura.RepositorioNotas;

import java.nio.file.Path;
import java.util.List;

/*public class testeLocalizadornotas {
    public static void main(String[] atgs) {

        Path caminhoVault = Path.of("C:\\Raziel\\raziel\\vault");

        RepositorioNotas repositorio = new RepositorioNotas(caminhoVault);
        LeitorVault leitorVault = new LeitorVault(caminhoVault);

        repositorio.carregarNotas(leitorVault);

        LocalizadorNotas localizador = new LocalizadorNotas(repositorio);

        List<RegistroNotas> resultados = localizador.busca("Encapsulamento");

        System.out.println("Anotações encontradas: " + resultados.size());

        for (RegistroNotas registro : resultados) {
            System.out.println(registro.getMetadados().getTitulo());
        }
    }
}
*/
