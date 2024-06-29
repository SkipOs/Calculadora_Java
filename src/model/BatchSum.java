package model;
import java.util.List;

public class BatchSum extends Model {
    private List<Integer> values;

    public BatchSum(List<Integer> values) {
        this.values = values;
    }

    @Override
    public void calculate() {
        int sum = values.stream().mapToInt(Integer::intValue).sum();
        setResult(sum);
    }
}
