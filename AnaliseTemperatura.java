import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

public class AnaliseTemperatura {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        
        String[] meses = {
            "Janeiro", "Fevereiro", "Março", "Abril", 
            "Maio", "Junho", "Julho", "Agosto", 
            "Setembro", "Outubro", "Novembro", "Dezembro"
        };
        
       
        List<Double> temperaturas = new ArrayList<>();
        
        double somaTemperaturas = 0.0;
        final int NUMERO_MESES = 12;

        System.out.println("--- ANÁLISE DE TEMPERATURA ANUAL ---");

        for (int i = 0; i < NUMERO_MESES; i++) {
            System.out.printf("Digite a temperatura média de %s: ", meses[i]);
            double temp = scanner.nextDouble();
            temperaturas.add(temp);
            somaTemperaturas += temp;
        }

        double mediaAnual = somaTemperaturas / NUMERO_MESES;

        System.out.println("\n-------------------------------------");
        System.out.printf("MÉDIA ANUAL CALCULADA: %.2f °C\n", mediaAnual);
        System.out.println("-------------------------------------");
        System.out.println("MESES COM TEMPERATURA ACIMA DA MÉDIA ANUAL:");


        for (int i = 0; i < NUMERO_MESES; i++) {
            double tempDoMes = temperaturas.get(i);
            
            
            if (tempDoMes > mediaAnual) {
                
                int numeroDoMes = i + 1; 
                String nomeDoMes = meses[i];
                
                System.out.printf("%d - %s: %.2f °C\n", numeroDoMes, nomeDoMes, tempDoMes);
            }
        }
        
        scanner.close();
        System.out.println("-------------------------------------");
    }
}        