import java.util.HashSet;
import java.util.Scanner;

/**
 * InputReader lê texto digitado da entrada padrão. 
 * O texto digitado pelo usuário é então dividido em palavras, e um conjunto
 * de palavras é fornecido.
 * 
 * @author     Michael Kolling and David J. Barnes
 * @version    0.3
 */
public class InputReader
{
    private Scanner reader;

    /**
     * Cria um novo InputReader que lê texto do terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * Lê uma linha de texto da entrada padrão, e a retorna como String.
     *
     * @return  A String digitada pelo usuário.
     */
    public HashSet<String> getInput() 
    {
        System.out.print("> ");                // imprime prompt
        String inputLine = reader.nextLine().trim().toLowerCase();

        String[] wordArray = inputLine.split(" ");  // separa por espaços

        // adiciona palavras de um array no hashset 
        HashSet<String> words = new HashSet<>();
        for(String word : wordArray) {
            words.add(word);
        }
        return words;
    }
}
