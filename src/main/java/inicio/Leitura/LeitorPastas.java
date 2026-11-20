package inicio.Leitura;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;
import java.util.stream.Stream;

public class LeitorPastas {


    private Path caminhopastas = Path.of("C:\\Kamehameha\\PROJETOS");

    public LeitorPastas(Path caminhopastas) {
        this.caminhopastas = caminhopastas;

    }

    public List<Path> localizadorProjetos() {
        List<Path> caminhos = new ArrayList<>();
        try {
            try (Stream<Path> list = Files.list(caminhopastas)
                    .filter(Files::isDirectory)
                    .filter(path -> {
                        try {
                            return !Files.isHidden(path);
                        } catch (IOException e) {
                            return false;
                        }

                    }).filter(Files::isReadable)) {
                list.forEach(path -> {
                    caminhos.add(path);
                });

            }

        } catch (IOException e) {
            System.out.println("erro n sei o que" + e);
        }
        return caminhos;

    } public List<Path> localizadorClasses(Path projeto) {
        List<Path> caminhos = new ArrayList<>();
        try {
            try (Stream<Path> lista = Files.walk(projeto)
                    .filter(Files::isRegularFile)
                    .filter(Files::isReadable)
                    .filter(path -> path.getFileName().toString().endsWith(".java"))) {
                lista.forEach(path -> {
                    caminhos.add(path);
                });
            }

        } catch (IOException e) {
            System.out.println("erro alguma coisa: " + e);

        }
        return caminhos;

    }


    }










