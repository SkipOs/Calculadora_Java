package model;

public class Sum extends Model {
    private int value1;
    private int value2;

    public Sum(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public void calculate() {
        setResult(value1 + value2);
    }
}
