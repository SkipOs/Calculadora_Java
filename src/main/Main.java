package main;

import facade.CalculatorFacade;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criar instância da Facade
        CalculatorFacade facade = new CalculatorFacade();
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!input.equalsIgnoreCase("EXIT")) {
            System.out.println("Menu:");
            System.out.println("1. Soma Individual");
            System.out.println("2. Subtração Individual");
            System.out.println("3. Soma em Lote (String)");
            System.out.println("4. Subtração em Lote (String)");
            System.out.println("5. Soma em Lote (Vetor)");
            System.out.println("6. Subtração em Lote (Vetor)");
            System.out.println("Digite 'EXIT' para sair.");
            System.out.print("Escolha uma opção: ");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Digite o primeiro valor: ");
                    int value1 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Digite o segundo valor: ");
                    int value2 = Integer.parseInt(scanner.nextLine());
                    double individualSumResult = facade.calculateIndividualSum(value1, value2);
                    System.out.println("Resultado Individual (Soma): " + individualSumResult);
                    break;

                case "2":
                    System.out.print("Digite o primeiro valor: ");
                    value1 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Digite o segundo valor: ");
                    value2 = Integer.parseInt(scanner.nextLine());
                    double individualSubtractionResult = facade.calculateIndividualSubtraction(value1, value2);
                    System.out.println("Resultado Individual (Subtração): " + individualSubtractionResult);
                    break;

                case "3":
                    System.out.print("Digite os valores separados por vírgula: ");
                    String valuesString = scanner.nextLine();
                    double batchSumResult = facade.calculateBatchSum(valuesString);
                    System.out.println("Resultado em Lote com String (Soma): " + batchSumResult);
                    break;

                case "4":
                    System.out.print("Digite os valores separados por vírgula: ");
                    valuesString = scanner.nextLine();
                    double batchSubtractionResult = facade.calculateBatchSubtraction(valuesString);
                    System.out.println("Resultado em Lote com String (Subtração): " + batchSubtractionResult);
                    break;

                case "5":
                    System.out.print("Digite os valores separados por vírgula: ");
                    valuesString = scanner.nextLine();
                    int[] valuesArray = parseStringToIntArray(valuesString);
                    double batchArraySumResult = facade.calculateBatchSum(valuesArray);
                    System.out.println("Resultado em Lote com Vetor (Soma): " + batchArraySumResult);
                    break;

                case "6":
                    System.out.print("Digite os valores separados por vírgula: ");
                    valuesString = scanner.nextLine();
                    valuesArray = parseStringToIntArray(valuesString);
                    double batchArraySubtractionResult = facade.calculateBatchSubtraction(valuesArray);
                    System.out.println("Resultado em Lote com Vetor (Subtração): " + batchArraySubtractionResult);
                    break;

                case "EXIT":
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static int[] parseStringToIntArray(String valuesString) {
        String[] stringValues = valuesString.split(",");
        int[] intValues = new int[stringValues.length];
        for (int i = 0; i < stringValues.length; i++) {
            intValues[i] = Integer.parseInt(stringValues[i].trim());
        }
        return intValues;
    }
}

