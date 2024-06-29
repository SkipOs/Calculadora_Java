package calculator;
import java.util.List;

import factory.BatchCalculationFactory;
import model.Model;

public class BatchCalculatorStrategy implements CalculatorStrategy {
    private BatchCalculationFactory factory;
    private List<Integer> values;
    private Model model;

    public BatchCalculatorStrategy(BatchCalculationFactory factory, List<Integer> values) {
        this.factory = factory;
        this.values = values;
        this.model = factory.createBatchCalculation(values);
    }

    @Override
    public void executeCalculation() {
        model.calculate();
    }

    @Override
    public double getResult() {
        return model.getResult();
    }
}
