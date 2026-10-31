package inicio.Leitura;

import inicio.Conhecimento.metadados;

import java.nio.file.Path;

public class RegistroNotas {
   private Path caminhoarquivo;
   private metadados metadados;

   public RegistroNotas (Path caminhoarquivo, metadados metadados){
       this.caminhoarquivo = caminhoarquivo;
       this.metadados = metadados;


   } Path getCaminhoarquivo (){
       return caminhoarquivo;

    } public metadados getMetadados(){
       return  metadados;
    }
}
