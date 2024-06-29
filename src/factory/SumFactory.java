package factory;

import model.Model;
import model.Sum;

public class SumFactory implements CalculationFactory {
    @Override
    public Model createCalculation(int value1, int value2) {
        return new Sum(value1, value2);
    }
}
