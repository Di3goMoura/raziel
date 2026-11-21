package inicio.Sala;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;


public class InterfaceTerminal {
    private static final String FIM_ENTRADA = "__FIM_ENTRADA";
    private final CentralComando centralComando;
    private final CiclodeVida ciclodeVida;
    private final Scanner scanner;
    private final BlockingQueue<String> filaPerguntas;
    private final Semaphore liberarLeitura;
    int ResgistroPerguntas = 0;

    public InterfaceTerminal(CentralComando centralComando, CiclodeVida ciclodeVida) {
        this.centralComando = centralComando;
        this.ciclodeVida = ciclodeVida;
        this.scanner = new Scanner(System.in);
        this.filaPerguntas = new LinkedBlockingQueue<>();
        this.liberarLeitura = new Semaphore(0);


    }

    public void Iniciar() {
        centralComando.ligar();
        ciclodeVida.ativar();
        mostrarTelaInicial();
        iniciarleitor();


        while (ciclodeVida.estaAtivo()) {
            liberarLeitura.release();
            String pergunta;
            try {
                pergunta = filaPerguntas.poll(5, TimeUnit.MINUTES);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                ciclodeVida.Encerrar();
                break;

            }
            if (pergunta == null) {
                ciclodeVida.Encerrar();
                break;
            }

            if (pergunta.equals(FIM_ENTRADA)) {
                ciclodeVida.Encerrar();
                break;


            }
            ciclodeVida.registarInteracao();
            String resposta = centralComando.processarPergunta(pergunta);
            for (int i = 0; i < resposta.length(); i++) {
                System.out.print(resposta.charAt(i));
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }


            }
            System.out.println();


            if (pergunta.equals("/stats")) {
                System.out.println("aqui esta a quantidade de perguntas feitas: " + ResgistroPerguntas);
            } else {
                ResgistroPerguntas++;
                continue;

            }
        }
    }


    public void mostrarTelaInicial() {
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("                                                                      RAZIEL");
        System.out.println("                                                           Assistente de Estudos em Java");
        System.out.println("                                                           Aprender | Praticar | Evoluir  ");
        System.out.println();

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println();
        System.out.println("Bem vindo ao RAZIEL. ");
        System.out.println("Digite sua pergunta para começar. ");
        System.out.println();
    }

    public void iniciarleitor() {
        Thread leitor = new Thread(() -> {
            try {
                Terminal terminal = TerminalBuilder.builder().system(true).build();
                LineReader leitorLinha = LineReaderBuilder.builder().terminal(terminal).build();

                while (ciclodeVida.estaAtivo()) {

                    liberarLeitura.acquire();
                    String pergunta = leitorLinha.readLine("voce > ");
                    filaPerguntas.offer(pergunta);
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                filaPerguntas.offer(FIM_ENTRADA);


            } catch (EndOfFileException e) {
                filaPerguntas.offer(FIM_ENTRADA);
                System.out.println("Erro: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Erro: " + e.getMessage());
                filaPerguntas.offer(FIM_ENTRADA);


            } catch (UserInterruptException e) {

                filaPerguntas.offer(FIM_ENTRADA);
            }
        });
        leitor.setDaemon(true);
        leitor.start();
    }


}


