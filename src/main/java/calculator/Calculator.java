package calculator;

public class Calculator {
    private int sum;

    public Calculator(int sum) {
        this.sum = sum;
    }

    public int add(String delimiter, String digit) {
        String[] arr = digit.split(delimiter);

        for (String s : arr) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
