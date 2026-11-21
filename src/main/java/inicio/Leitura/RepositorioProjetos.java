package inicio.Leitura;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RepositorioProjetos {
    private Path caminhoProjeto;
    private List<Path> projetos;
    private List<RegistroNotas> registros;
    private List<List<Path>> classesporprojetos = new ArrayList<>();


    public RepositorioProjetos() {
        this.projetos = new ArrayList<>();

    }

    public void armazenarprojetos(LeitorPastas leitorPastas) {
        List<Path> projetosnecontradoas = leitorPastas.localizadorProjetos();
        projetos.addAll(projetosnecontradoas);
        for (Path projeto : projetosnecontradoas) {
            classesporprojetos.add(leitorPastas.localizadorClasses(projeto));


        }

    }

    public void listarcodigo(Path nomeClsse) {
                    try {
                        String codigo = Files.readString(nomeClsse);
                        System.out.println(codigo);
                    } catch (IOException e) {
                        System.out.println("erro ao ler a classe: " + e.getMessage());
                    }
                }



    public void listarprojetos() {
        for (Path projeto : projetos) {
            System.out.println(projeto.getFileName());
        }
    }

    public List<Path> getProjetos() {
        return projetos;
    }

    public List<Path> getClasssProjetoes(Path projeto) {
        int indice = projetos.indexOf(projeto);
        if (indice == -1) {
            List<Path> lista = new ArrayList<>();
            return lista;

        }
        return classesporprojetos.get(indice);

    } public void listarClasses(Path projeto){
        List<Path> lista = getClasssProjetoes(projeto);
        for (Path classe : lista){
            System.out.println(classe.getFileName());
        }
    }
}



