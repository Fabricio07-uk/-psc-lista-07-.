import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

public class CalculadoraComissao {

   
    private static final double SALARIO_BASE = 200.00;
    private static final double TAXA_COMISSAO = 0.09; 

    public static void main(String[] args) {
        
    
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        
    
        List<Integer> contadoresFaixa = new ArrayList<>();
     
        for (int i = 0; i < 9; i++) {
            contadoresFaixa.add(0);
        }

        System.out.println("--- CALCULADORA DE COMISSÃO E CLASSIFICADOR SALARIAL ---");
        System.out.println("O salário é: $200 + 9% das vendas brutas.");
        System.out.println("Digite as vendas brutas de cada vendedor. Digite -1 para encerrar.");
        System.out.println("----------------------------------------------------------");

        double vendasBrutas;
        int totalVendedores = 0;

        while (true) {
            System.out.print("Vendas brutas do vendedor " + (totalVendedores + 1) + " (ou -1 para encerrar): $");
            
            if (scanner.hasNextDouble()) {
                vendasBrutas = scanner.nextDouble();
                
                if (vendasBrutas == -1) {
                    break;
                }
                
                if (vendasBrutas < 0) {
                    System.out.println("Vendas não podem ser negativas. Tente novamente.");
                    continue;
                }

                totalVendedores++;
                
                double comissao = vendasBrutas * TAXA_COMISSAO;
                double salarioTotal = SALARIO_BASE + comissao;
                
                System.out.printf("   [INFO] Salário Total Calculado: $%.2f\n", salarioTotal);
                
                int indiceFaixa;
              
                indiceFaixa = (int) Math.floor(salarioTotal / 100.0) - 2;

                if (indiceFaixa >= 8) {
     
                    indiceFaixa = 8;
                }
                
                if (indiceFaixa >= 0) {
                   
                    int contadorAtual = contadoresFaixa.get(indiceFaixa);
                    contadoresFaixa.set(indiceFaixa, contadorAtual + 1);
                }
               
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next();
            }
        }
        
        scanner.close();

        System.out.println("\n\n--- RELATÓRIO FINAL DE CLASSIFICAÇÃO SALARIAL ---");
        System.out.println("Total de Vendedores Processados: " + totalVendedores);
        System.out.println("-------------------------------------------------");

        String[] faixasRotulos = {
            "$200 - $299", "$300 - $399", "$400 - $499", "$500 - $599",
            "$600 - $699", "$700 - $799", "$800 - $899", "$900 - $999",
            "$1000 ou mais"
        };
        
        for (int i = 0; i < contadoresFaixa.size(); i++) {
            System.out.printf("%-15s: %d\n", faixasRotulos[i], contadoresFaixa.get(i));
        }
        System.out.println("-------------------------------------------------");
    }
}