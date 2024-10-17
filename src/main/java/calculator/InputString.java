package calculator;

public class InputString {
    private int sum;

    public InputString(String input) {
        if(input == null || input.isEmpty()) {
            sum = 0;
        }
    }

    public int getSum() {
        return sum;
    }

}
