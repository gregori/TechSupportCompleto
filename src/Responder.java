import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/**
 * A classe responder representa um objeto gerador de resposta.
 * É usada para gerar uma resposta automática.
 * Esta é a segunda versão desta classe. Desta vez, geramos
 * algum comportamento aleatório, selecionando uma frase de uma lista
 * predefinida de respostas.
 * 
 * @author     Michael Kolling and David J. Barnes
 * @version    0.2
 */
public class Responder
{
    // usado para mapear palavras a respostas
    private HashMap<String, String> responseMap;
    // Respostas padrão se não reconhecermos uma palavra
    private ArrayList<String> defaultResponses;
    private Random randomGenerator;

    /**
     * Constrói um Responder
     */
    public Responder()
    {
        responseMap = new HashMap<>();
        defaultResponses = new ArrayList<>();
        fillResponseMap();
        fillDefaultResponses();
        randomGenerator = new Random();
    }

    /**
     * Gera uma resposta a partir de um conjunto de palavras
     * 
     * @param words  Um conjunto de palavras entrado pelo usuário
     * @return  Uma String que deve ser mostrada como a resposta
     */
    public String generateResponse(HashSet<String> words)
    {
        Iterator<String> it = words.iterator();
        while(it.hasNext()) {
            String word = it.next();
            String response = responseMap.get(word);
            if(response != null) {
                return response;
            }
        }
        // Se chegarmos aqui, nenhuma das palavras da entrada foi reconhecida.
        // Neste caso, nós escolhemos uma das nossas respostas padrão (que dizemos
        // quando não sabemos o que mais dizer...)
        return pickDefaultResponse();
    }
    
    /**
     * Entra todas as palavras-chave conhecidas e suas respostas associadas
     * no nosso mapa de respostas.
     */
    private void fillResponseMap()
    {
        responseMap.put("travou", 
                        "Bem, nunca trava aqui. Deve ter algo a ver com seu sistema.\n" +
                        "Conte-me mais sobre sua configuração.");
        responseMap.put("trava", 
                        "Bem, nunca trava aqui. Deve ter algo a ver com seu sistema.\n" +
                        "Conte-me mais sobre sua configuração.");
        responseMap.put("lento", 
                        "Eu acho que tem a ver com seu hardware. Atualizar seu processador\n" +
                        "deve resolver todos os problemas de performance. Você tem algum problema comh\n" +
                        "nosso software?");
        responseMap.put("performance", 
                        "A performance em nossos testes é adequada. Você está executando\n" +
                        "outros processos junto com o software?");
        responseMap.put("bug", 
                        "Bom, todos os softwares têm bugs. Mas nossos engenheiros\n" +
                        "estão trabalhando duro para corrigi-los.  Você pode descrever melhor\n" +
                        "seu problema?");
        responseMap.put("bugado", 
                        "Bom, todos os softwares têm bugs. Mas nossos engenheiros\n" +
                        "estão trabalhando duro para corrigi-los.  Você pode descrever melhor\n" +
                        "seu problema?");
        responseMap.put("windows", 
                        "Este é um bug conhecido relacionado ao Windows. Por favor\n" +
                        "reporte-o à Microsoft. Não há nada que possamos fazer sobre isso.");
        responseMap.put("mac", 
                        "Este é um bug conhecido relacionado ao Mac. Por favor\n" +
                        "reporte-o à Apple. Não há nada que possamos fazer sobre isso.");
        responseMap.put("caro", 
                        "O custo do nosso produto é muito competitivo. Já comparou\n" +
                        "nossas especificações com a de outros sistemas?");
        responseMap.put("instalação", 
                        "A instalação é realmente simples. Temos diversos\n" +
                        "wizards que fazem todo o trabalho para você. Já leu as instruções de\n" +
                        "instalação?");
        responseMap.put("memória", 
                        "Se você ler cuidadosamente os requisitos do sistema, verá que\n" +
                        "a memória especificada é de, ao menos, 2 giga bytes. Você realmente deve\n" +
                        "atualizar sua memória. Você gostaria saber algo mais?");
        responseMap.put("linux", 
                        "Nós levamos muito a sério o suporte ao Linux. Mas há alguns problemas.\n" +
                        "A maioria, relacionada a versões incompatíveis da glibc. Você pode ser um pouco\n" +
                        "mais preciso?");
        responseMap.put("bluej", 
                        "Ahhh, o BlueJ, sim. Nós tentamos comprar a empresa deles há muito tempo, mas\n" +
                        "eles simplesmente não querem vender... São teimosos. Sinto, mas não há nada\n" +
                        "que possamos fazer quanto a isso.");
    }

    /**
     * Constrói uma lista de respostas padrão, a partir da qual escolhemos uma
     * se não soubermos o que mais dizer.
     */
    private void fillDefaultResponses()
    {
        defaultResponses.add("Isso soa estranho. Poderia detalhar esse problema?");
        defaultResponses.add("Nenhum outro cliente jamais reclamou sobre isso. \n" +
                      "Qual é a configuração do seu sistema?");
        defaultResponses.add("Isso parece interessante. Diga-me mais...");
        defaultResponses.add("Eu preciso de mais informação sobre isso.");
        defaultResponses.add("Já checou se você não tem um conflito de dll?");
        defaultResponses.add("Isso é explicado no manual. Você já leu o manual?");
        defaultResponses.add("Sua descrição é bem falha. Você tem um especialista aí\n" +
                      "que poderia descrever isso com mais detalhes?");
        defaultResponses.add("Isso não é um bug, é uma funcionalidade!");
        defaultResponses.add("Você poderia elaborar mais isso?");
    }
    
    /**
     * Seleciona aleatoriamente e retorna uma das respostas padrão.
     * @return     Uma resposta padrão aleatória
     */
    private String pickDefaultResponse()
    {
        // Escolhe um número aleatório do índicena lista de respostas padrão.
        // O número será entre 0 (inclusive) e o tamanho da lista (exclusive).
        int index = randomGenerator.nextInt(defaultResponses.size());
        return defaultResponses.get(index);
    }
}
