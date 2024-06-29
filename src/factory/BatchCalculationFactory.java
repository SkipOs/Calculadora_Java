package factory;
import java.util.List;

import model.Model;

public interface BatchCalculationFactory {
    Model createBatchCalculation(List<Integer> values);
}
