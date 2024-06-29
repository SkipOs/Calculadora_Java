package model;

import java.util.List;

public class BatchSubtraction extends Model {
    private List<Integer> values;

    public BatchSubtraction(List<Integer> values) {
        this.values = values;
    }

    @Override
    public void calculate() {
        if (values == null || values.isEmpty()) {
            setResult(0);
            return;
        }

        int result = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            result -= values.get(i);
        }
        setResult(result);
    }
}
