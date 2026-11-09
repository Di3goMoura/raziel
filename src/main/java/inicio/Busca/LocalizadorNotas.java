package inicio.Busca;

import inicio.Leitura.RegistroNotas;
import inicio.Leitura.RepositorioNotas;

import java.util.HashMap;
import java.util.Map;

public class LocalizadorNotas {

    private final RepositorioNotas repositorioNotas;
    private final Map<String, RegistroNotas> notasPorId;

    public LocalizadorNotas(RepositorioNotas repositorioNotas){
        this.repositorioNotas = repositorioNotas;
        notasPorId = new  HashMap<>();
    } public void indexNotas(){
        notasPorId.clear();
        for (RegistroNotas notas: repositorioNotas.getRegistros()){
            String id = notas.getMetadados().getId();

            if (notasPorId.containsKey(id)){
                throw new IllegalArgumentException("ID duplicado: " + id);
            } notasPorId.put(id, notas);
        }
    } public RegistroNotas buscaPorId (String id){
      return   notasPorId.get(id);

    }

}