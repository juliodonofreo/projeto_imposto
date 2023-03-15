package aplicacao;

import entidades.Contribuinte;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Numero de contribuintes: ");
        int numeroContribuintes = sc.nextInt();
        Contribuinte[] contribuintes = new Contribuinte[numeroContribuintes];

        for(int i = 0; i < contribuintes.length; i++){
            char tipo;

            System.out.println("Dados do contribuinte " + (i + 1));
            do {
                System.out.print("Individual ou companhia: (i/c)");
                tipo = sc.next().toLowerCase().charAt(0);
            } while (tipo != 'i' && tipo != 'c');
            sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Renda anual: ");
            double rendaAnual = sc.nextDouble();

            if(tipo == 'i') {
                System.out.print("Gastos com saúde: ");
                double gastosSaude = sc.nextDouble();
                contribuintes[i] = new PessoaFisica(nome, rendaAnual, gastosSaude);
            }
            else {
                System.out.print("Número de funcionários: ");
                int numeroFuncionarios = sc.nextInt();
                contribuintes[i] = new PessoaJuridica(nome, rendaAnual, numeroFuncionarios);
            }
        }

        System.out.println();
        System.out.println();

        double totalImpostos = 0;
        for (Contribuinte contribuinte: contribuintes) {
            System.out.printf("%s: R$%.2f%n", contribuinte.getNome(), contribuinte.imposto());
            totalImpostos += contribuinte.imposto();
        }

        System.out.println();
        System.out.print("Total de impostos: " + totalImpostos);
        
        sc.close();
    }
}
