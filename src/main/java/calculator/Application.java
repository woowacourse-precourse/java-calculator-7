package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("Please enter the string to be added.");
        String input = Console.readLine();

        String[] result = extractCustomDelimiter(input);
        String delimiter = result[0];
        String numberString = result[1];

        List<Integer> numbers = parseNumbers(numberString, delimiter);
        System.out.println("Parsed numbers: " + numbers);
    }

    public static String[] extractCustomDelimiter(String input) {
        String delimiter = ",|:";
        String numberString = input;

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            if (delimiterIndex != -1) {
                delimiter = input.substring(2, delimiterIndex);
                numberString = input.substring(delimiterIndex + 1);
            }
        }

        return new String[]{delimiter, numberString};
    }

    public static List<Integer> parseNumbers(String input, String delimiter) {
        List<Integer> numbers = new ArrayList<>();
        String[] splitNumbers = input.split(delimiter);

        for (String number : splitNumbers) {
            try {
                int parsedNumber = Integer.parseInt(number.trim());
                numbers.add(parsedNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("INVALID INPUT");
            }
        }

        return numbers;
    }
}
