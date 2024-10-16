package refactor;

public class CalculatorMethod {
    int add(String[] delimitedNumbers) {
        int sum = 0;
        for (String delimitedNumber : delimitedNumbers) {
            sum += Integer.parseInt(delimitedNumber);
        }
        return sum;
    }
}
