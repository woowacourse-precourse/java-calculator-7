package calculator.number;

public class DoubleSum implements NumberSum {
    public double sum;

    @Override
    public void add(double amount) {
        sum += amount;
    }

    @Override
    public double getValue() {
        return sum;
    }

    @Override
    public boolean isWholeNumber() {
        return Math.floor(sum) == sum;
    }
}
