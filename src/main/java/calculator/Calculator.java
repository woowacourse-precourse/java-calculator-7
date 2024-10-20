package calculator;

public class Calculator {

    public int run(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:]";
        String numberString = input;

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            delimiter = input.substring(2, delimiterIndex);
            numberString = input.substring(delimiterIndex + 2);
        }

        String[] numberArray = numberString.split(delimiter);
        int sum = 0;

        for (String number : numberArray) {
            if (!number.isEmpty()) {
                sum += Integer.parseInt(number);
            }
        }

        return sum;
    }
}
