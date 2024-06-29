package factory;

import model.BatchSubtraction;
import model.Model;

import java.util.List;

public class BatchSubtractionFactory implements BatchCalculationFactory {
    @Override
    public Model createBatchCalculation(List<Integer> values) {
        return new BatchSubtraction(values);
    }
}
