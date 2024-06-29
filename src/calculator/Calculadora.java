package calculator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import factory.BatchCalculationFactory;
import factory.CalculationFactory;
import model.Model;

public class Calculadora implements CalculatorStrategy, Observer {
    private Model model;
    private CalculationFactory calculationFactory;
    private BatchCalculationFactory batchCalculationFactory;

    // Construtor que permite a injeção de dependências das fábricas de cálculo
    public Calculadora(CalculationFactory calculationFactory) {
        this.calculationFactory = calculationFactory;
    }

    public Calculadora(BatchCalculationFactory batchCalculationFactory) {
        this.batchCalculationFactory = batchCalculationFactory;
    }

    // Método para configurar a instância de cálculo individual
    public void setIndividualCalculation(int value1, int value2) {
        this.model = calculationFactory.createCalculation(value1, value2);
        this.model.addObserver(this);
    }

    // Método para configurar a instância de cálculo em lote
    public void setBatchCalculation(List<Integer> values) {
        this.model = batchCalculationFactory.createBatchCalculation(values);
        this.model.addObserver(this);
    }

    // Implementação do método executeCalculation da interface CalculatorStrategy
    @Override
    public void executeCalculation() {
        if (model != null) {
            model.calculate();
        }
    }

    // Implementação do método getResult da interface CalculatorStrategy
    @Override
    public double getResult() {
        if (model != null) {
            return model.getResult();
        }
        return 0;
    }

    // Implementação do método update da interface Observer
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Model) {
            System.out.println("Resultado atualizado: " + ((Model) o).getResult());
        }
    }
}
