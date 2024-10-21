package calculator;

public class Adder {
    public int run(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] stringNumbers = input.split("[,:]");
        int sum = 0;

        for (String stringNumber : stringNumbers) {
            int number = Integer.parseInt(stringNumber);
            sum += number;
        }
        return sum;
    }
}
