package controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import adapter.BatchCalculationAdapter;
import model.Model;
import calculator.Calculadora;
import factory.CalculationFactory;

public class Controller {
    private Calculadora calculadora;
    private BatchCalculationAdapter batchCalculationAdapter;

    // Construtor que injeta a dependência da Calculadora
    public Controller(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    // Construtor que injeta a dependência do Adapter de cálculo em lote
    public Controller(BatchCalculationAdapter batchCalculationAdapter) {
        this.batchCalculationAdapter = batchCalculationAdapter;
    }

    // Método para executar cálculo individual
    public void performIndividualCalculation(int value1, int value2) {
        calculadora.setIndividualCalculation(value1, value2);
        calculadora.executeCalculation();
    }

    // Método para executar cálculo em lote com string
    public void performBatchCalculation(String values) {
        List<Integer> valueList = Arrays.asList(values.split(",")).stream()
                                          .map(Integer::parseInt)
                                          .collect(Collectors.toList());
        calculadora.setBatchCalculation(valueList);
        calculadora.executeCalculation();
    }

    // Método para executar cálculo em lote com vetor de inteiros
    public void performBatchCalculation(int[] values) {
        batchCalculationAdapter.setBatchCalculation(values);
        batchCalculationAdapter.executeCalculation();
    }

    // Método para obter o resultado do cálculo
    public double getResult() {
        return calculadora != null ? calculadora.getResult() : batchCalculationAdapter.getResult();
    }
}
