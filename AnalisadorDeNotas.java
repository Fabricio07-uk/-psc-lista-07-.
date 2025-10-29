import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

public class AnalisadorDeNotas {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        
        List<Double> notas = new ArrayList<>();
        double notaLida;

        System.out.println("--- ANALISADOR DE NOTAS ---");
        System.out.println("Digite as notas. Digite -1 para encerrar a entrada de dados.");
        System.out.println("---------------------------");

        while (true) {
            System.out.print("Nota: ");
            

            if (scanner.hasNextDouble()) {
                notaLida = scanner.nextDouble();
                

                if (notaLida == -1) {
                    break;
                }
                
                notas.add(notaLida);
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next(); 
            }
        }
        
        System.out.println("\n---------------------------");
        
  
        if (notas.isEmpty()) {
            System.out.println("Nenhuma nota válida foi informada. Encerrando.");
            scanner.close();
            return;
        }

        int quantidadeValores = notas.size();
        System.out.println("1. Quantidade de valores lidos: " + quantidadeValores);

        System.out.print("2. Valores informados (Ordem Original): ");
        for (double nota : notas) {
            System.out.printf("%.1f ", nota);
        }
        System.out.println();

        
        System.out.println("3. Valores na Ordem Inversa:");
      
        for (int i = notas.size() - 1; i >= 0; i--) {
            System.out.printf("   - %.1f\n", notas.get(i));
        }

        double somaValores = 0;
        for (double nota : notas) {
            somaValores += nota;
        }
        System.out.printf("4. Soma dos valores: %.2f\n", somaValores);

        double mediaValores = somaValores / quantidadeValores;
        System.out.printf("5. Média dos valores: %.2f\n", mediaValores);

        int acimaDaMedia = 0;
        for (double nota : notas) {
            if (nota > mediaValores) {
                acimaDaMedia++;
            }
        }
        System.out.println("6. Quantidade de valores acima da média: " + acimaDaMedia);

        int abaixoDeSete = 0;
        for (double nota : notas) {
            if (nota < 7.0) {
                abaixoDeSete++;
            }
        }
        System.out.println("7. Quantidade de valores abaixo de 7.0: " + abaixoDeSete);

        System.out.println("---------------------------");
        System.out.println("PROGRAMA ENCERRADO: Análise de notas finalizada com sucesso!");
        
        scanner.close();
    }
}