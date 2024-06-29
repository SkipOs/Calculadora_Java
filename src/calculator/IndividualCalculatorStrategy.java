package calculator;

import factory.CalculationFactory;
import model.Model;

public class IndividualCalculatorStrategy implements CalculatorStrategy {
    private CalculationFactory factory;
    private int value1;
    private int value2;
    private Model model;

    public IndividualCalculatorStrategy(CalculationFactory factory, int value1, int value2) {
        this.factory = factory;
        this.value1 = value1;
        this.value2 = value2;
        this.model = factory.createCalculation(value1, value2);
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
