
import java.util.HashSet;

/**
 * Esta classe implementa um sistema de suporte técnico. É a classe de mais alto
 * nível neste projeto. O sistema de suporte se comunica via entrada/saída de
 * texto no terminal.
 * 
 * Esta classe usa um objeto da classe InputReader para ler a entrada do usuário,
 * e um objeto da classe Responder para gerar respostas.
 * Ela contém um loop que vai ler a entrada repetidamente e gerar a saída
 * até que o usuário resolva sair.
 * 
 * @author     Michael Kolling and David J. Barnes
 * @version    0.2
 */
public class SupportSystem
{
    private InputReader reader;
    private Responder responder;
    
    /**
     * Cria um sistema de suporte técnico.
     */
    public SupportSystem()
    {
        reader = new InputReader();
        responder = new Responder();
    }

    /**
     * Inicia o sistema de suporte técnico. Vai imprimir uma mensagem de
     * boas-vindas e abrir um diálogo com o usuário, até que o usuário
     * o encerre.
     */
    public void start()
    {
        boolean finished = false;

        printWelcome();

        while(!finished) {
            HashSet<String> input = reader.getInput();

            if(input.contains("bye")) {
                finished = true;
            }
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
        printGoodbye();
    }

    /**
     * Imprime uma mensagem de boas-vindas na tela.
     */
    private void printWelcome()
    {
        System.out.println("Bem-vindo ao Sistema de Suporte Tecnico da DodgySoft.");
        System.out.println();
        System.out.println("Por favor, conte-nos seu problema.");
        System.out.println("Vamos auxiliá-lo com qualquer problema que você possa ter.");
        System.out.println("Por favor, digite 'bye' para sair de nosso sistema.");
    }

    /**
     * Imprime uma mensagem de despedida na tela.
     */
    private void printGoodbye()
    {
        System.out.println("Foi um prazer falar com você. Tchau...");
    }
}
