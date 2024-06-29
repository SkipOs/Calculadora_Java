package factory;

import model.Model;
import model.Subtraction;

public class SubtractionFactory implements CalculationFactory {
    @Override
    public Model createCalculation(int value1, int value2) {
        return new Subtraction(value1, value2);
    }
}

