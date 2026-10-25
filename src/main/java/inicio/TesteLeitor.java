package inicio;

import inicio.Leitura.LeitorVault;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TesteLeitor {

    public static void main(String[] args) {

        Path caminhoVault = Path.of("C:\\Raziel\\raziel\\vault\\01-conceitos");

        LeitorVault leitorVault = new LeitorVault(caminhoVault);
        List<Path>arquivos = leitorVault.localizarArquivos();
        arquivos.forEach(arquivo -> System.out.println(arquivo));
    }

}
