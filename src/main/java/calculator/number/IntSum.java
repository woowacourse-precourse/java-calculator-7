package calculator.number;

public class IntSum implements NumberSum {

    public int sum;

    public IntSum() {
        this.sum = 0;
    }

    @Override
    public void add(double amount) {
        sum += (int) amount;
    }

    @Override
    public double getValue() {
        return this.sum;
    }

    @Override
    public boolean isWholeNumber() {
        return true;
    }
}
