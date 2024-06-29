package factory;
import java.util.List;

import model.BatchSum;
import model.Model;

public class BatchSumFactory implements BatchCalculationFactory {
    @Override
    public Model createBatchCalculation(List<Integer> values) {
        return new BatchSum(values);
    }
}
