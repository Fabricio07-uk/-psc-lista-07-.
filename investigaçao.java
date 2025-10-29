import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class investigaçao {

    /**
     
     * @param scanner 
     * @param pergunta 
     * @return 
     */
    public static boolean obterRespostaSimNao(Scanner scanner, String pergunta) {
        String resposta;
        while (true) {
            System.out.printf("%s (SIM/NAO): ", pergunta);
            resposta = scanner.nextLine().trim();

            if (resposta.equalsIgnoreCase("SIM")) {
                return true;
            } else if (resposta.equalsIgnoreCase("NAO")) {
                return false;
            } else {
                System.out.println("-> Resposta inválida. Por favor, digite SIM ou NAO.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> perguntas = new ArrayList<>();
        perguntas.add("Telefonou para a vítima?");
        perguntas.add("Esteve no local do crime?");
        perguntas.add("Mora perto da vítima?");
        perguntas.add("Devia para a vítima?");
        perguntas.add("Já trabalhou com a vítima?");

        int contagemRespostasPositivas = 0;

        System.out.println("--- INÍCIO DA INVESTIGAÇÃO ---");
        System.out.println("Por favor, responda às 5 perguntas com SIM ou NAO.");
        System.out.println("-----------------------------");

        for (String pergunta : perguntas) {
            boolean resposta = obterRespostaSimNao(scanner, pergunta);
            
            if (resposta) {
                contagemRespostasPositivas++;
            }
        }

        String classificacao;

        if (contagemRespostasPositivas == 5) {
            classificacao = "Assassino";
        } else if (contagemRespostasPositivas >= 3 && contagemRespostasPositivas <= 4) {
            classificacao = "Cúmplice";
        } else if (contagemRespostasPositivas == 2) {
            classificacao = "Suspeita";
        } else { 
            classificacao = "Inocente";
        }

        System.out.println("\n-----------------------------");
        System.out.println("         RESULTADO FINAL         ");
        System.out.println("-----------------------------");
        System.out.println("Total de respostas positivas: " + contagemRespostasPositivas);
        System.out.println("Classificação: " + classificacao);
        System.out.println("-----------------------------");

        scanner.close();
    }
}