package calculator.business;

public class CalculatorService {
    private String delimiter;


    public int run(String input) {
        String inputWithoutDelimiter = selectCalculateMode(input);
        int[] numbers = convertStringToInt(inputWithoutDelimiter);
        return calculate(numbers);
    }

    private int calculate(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    private int[] convertStringToInt(String input) {
        String[] inputString = input.split(delimiter);
        int[] numbers = new int[inputString.length];

        for (int i = 0; i < inputString.length; i++) {

            int parsedNumber;
            try {
                parsedNumber = Integer.parseInt(inputString[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

            if (parsedNumber < 0) {
                throw new IllegalArgumentException();
            }

            numbers[i] = parsedNumber;
        }

        return numbers;
    }

    private String selectCalculateMode(String input) {

        if (input.startsWith("//")) {
            delimiter = input.substring(2, 3);
            input = input.substring(5);
        } else {
            delimiter = "[,:]";
        }

        return input;
    }

}
