package factory;
import model.Model;

public interface CalculationFactory {
    Model createCalculation(int value1, int value2);
}
