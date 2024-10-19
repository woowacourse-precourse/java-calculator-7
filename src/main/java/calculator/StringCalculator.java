package calculator;

public class StringCalculator {
    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        String numberString = input;

        if (input.startsWith("//")) {
            if (input.charAt(3) == '\\' && input.charAt(4) == 'n') {
                delimiter = String.valueOf(input.charAt(2));
                numberString = input.substring(5);
            }
        }

        String[] numbers = splitString(numberString, delimiter);
        int sum = sumNumbers(numbers);

        return sum;
    }

    private String[] splitString(String numberString, String delimiter) {
        return numberString.split(delimiter, -1);
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if(!number.isEmpty()) {
                sum += Integer.parseInt(number);
            }
        }
        return sum;
    }
}
