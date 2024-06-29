package adapter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import calculator.Calculadora;

public class BatchCalculationAdapterImpl implements BatchCalculationAdapter {
    private Calculadora calculadora;

    public BatchCalculationAdapterImpl(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    @Override
    public void setBatchCalculation(int[] values) {
        // Converter vetor de inteiros para lista de inteiros
        List<Integer> valueList = Arrays.stream(values).boxed().collect(Collectors.toList());
        calculadora.setBatchCalculation(valueList);
    }

    @Override
    public void executeCalculation() {
        calculadora.executeCalculation();
    }

    @Override
    public double getResult() {
        return calculadora.getResult();
    }
}

