package calculator.business;

public class CalculatorService {
    private String delimiter;


    public int run(String input) {
        String inputWithoutDelimiter = selectPrefix(input);
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
            numbers[i] = Integer.parseInt(inputString[i]);
        }

        return numbers;
    }

    private String selectPrefix(String input) {

        if (input.startsWith("//")) {
            delimiter = input.substring(2, 3);
            input = input.substring(5);
        } else {
            delimiter = "[,:]";
        }

        return input;
    }

}
