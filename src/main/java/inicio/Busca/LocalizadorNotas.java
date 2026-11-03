package inicio.Busca;

import inicio.Leitura.RegistroNotas;
import inicio.Leitura.RepositorioNotas;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorNotas {
    private RepositorioNotas repositorioNotas;

    public LocalizadorNotas(RepositorioNotas repositorioNotas) {
        this.repositorioNotas = repositorioNotas;


    }

    public static void main(String[] args) {

    }

    public List<RegistroNotas> busca(String assuntoProcurado) {
        List<RegistroNotas> nota = new ArrayList<>();


        for (RegistroNotas notas : repositorioNotas.getRegistros()) {
            Boolean encontrou = false;
            if (assuntoProcurado.equalsIgnoreCase(notas.getMetadados().getId()) || assuntoProcurado.equalsIgnoreCase(notas.getMetadados().getTitulo())
                    || assuntoProcurado.equalsIgnoreCase(notas.getMetadados().getAssunto()) || assuntoProcurado.equalsIgnoreCase(notas.getMetadados().getCategoria())) {
                encontrou = true;
            }

            for (String palavrachave : notas.getMetadados().getPalavrasChave()) {
                if (assuntoProcurado.equalsIgnoreCase(palavrachave)) {
                    encontrou = true;

                }

            }
            if (encontrou) {
                nota.add(notas);
            }

        }
        return nota;

    }

}





