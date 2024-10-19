package calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * This class parses the input string and calculates the sum of a list of integers.
 */
public class StringCalculator {

    /**
     * This method returns default separators
     * @return default separators
     */
    private ArrayList<String> getDefaultSeparator() {
        return new ArrayList<>(List.of(",", ":"));
    }

    /**
     * This method return custom separators
     * @param input The string to get custom separator
     * @return A list of default separators + custom separator
     */
    private ArrayList<String> getCustomSeparator(String input) {
        ArrayList<String> separators = getDefaultSeparator();

        String custom_separator = input.split("\\\\n")[0];
        custom_separator = custom_separator.substring(2);
        separators.add(custom_separator);

        return separators;
    }

    /**
     * This method return numbers separated by separators
     * @param input The string to get numbers
     * @param separators The string to split numbers
     * @return A list of numbers
     */
    private String[] getNumbers(String input, ArrayList<String> separators) {
        String number_string;
        if (input.startsWith("//")) {
            number_string = input.split("\\\\n")[1];
        } else {
            number_string = input;
        }

        String separator = String.join("|", separators);

        return number_string.split(separator);
    }

    /**
     * This method return sum of numbers separated by separators
     * @param input The string to sum
     * @return A sum of input numbers
     */
    public int calculate(String input) {

        ArrayList<String> separators;

        if (input.startsWith("//")) {
            separators = getCustomSeparator(input);
        } else {
            separators = getDefaultSeparator();
        }

        String[] numbers = getNumbers(input, separators);

        int sum = 0;

        for (String number : numbers) {
            try {
                int num = Integer.parseInt(number);
                if (num <= 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
                sum += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구분자가 올바르지 않습니다.");
            }
        }

        return sum;
    }
}
