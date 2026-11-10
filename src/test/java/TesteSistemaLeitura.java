import inicio.Sala.SistemaLeitura;

import java.nio.file.Path;

public class TesteSistemaLeitura {
    public static void main (String [] args){
        SistemaLeitura sistemaLeitura1 = new SistemaLeitura(Path.of("C:\\Raziel\\raziel\\vault\\01-conceitos"));

        sistemaLeitura1.iniciarLeitura();


    }








}
