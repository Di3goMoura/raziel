package inicio.Sala;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class InterfaceTerminal {
    private static final String FIM_ENTRADA = "__FIM_ENTRADA";
    private final CentralComando centralComando;
    private final CiclodeVida ciclodeVida;
    private final Scanner scanner;
    private final BlockingQueue<String> filaPerguntas;

    public InterfaceTerminal(CentralComando centralComando, CiclodeVida ciclodeVida) {
        this.centralComando = centralComando;
        this.ciclodeVida = ciclodeVida;
        this.scanner = new Scanner(System.in);
        this.filaPerguntas = new LinkedBlockingQueue<>();


    }

    public void Iniciar() {
        centralComando.ligar();
        ciclodeVida.ativar();
        mostrarTelaInicial();
        iniciarleitor();

        while (ciclodeVida.estaAtivo()) {
            System.out.println("Escreva sua Pergunta: ");
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
            System.out.println(resposta);
            System.out.println();
        }

    } public void mostrarTelaInicial(){
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
            while (scanner.hasNextLine()) {
                String perfunta = scanner.nextLine();
                filaPerguntas.offer(perfunta);
            }
        });
        leitor.setDaemon(true);
        leitor.start();
    }
}

