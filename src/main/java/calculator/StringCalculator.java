package calculator;

import java.util.Arrays;

/**
 * This class parses the input string and calculates the sum of a list of integers.
 */
public class StringCalculator {

    /**
     * This method returns default separators
     * @return A String of default separators
     */
    private String getDefaultSeparator() {
        return ",|:";
    }

    /**
     * This method return custom separators
     * @param input The string to get custom separator
     * @return A String of custom separators and default separators sorted by each length
     */
    private String getCustomSeparator(String input) {
        String separators = getDefaultSeparator();

        String custom_separator = input.split("\\\\n")[0];
        custom_separator = custom_separator.substring(2);
        separators = separators + "|" + custom_separator;

        String[] separators_array = separators.split("\\|");
        Arrays.sort(separators_array, (s1, s2) -> s2.length() - s1.length());

        separators = String.join("|", separators_array);

        return separators;
    }

    /**
     * This method return numbers separated by separators
     * @param input The string to get numbers
     * @param separators The string to split numbers
     * @return A list of numbers
     */
    private String[] getNumbers(String input, String separators) {
        String number_string;
        if (input.startsWith("//")) {
            number_string = input.split("\\\\n")[1];
        } else {
            number_string = input;
        }

        return number_string.split(separators);
    }

    /**
     * This method return sum of numbers separated by separators
     * @param input The string to sum
     * @return A sum of input numbers
     */
    public int calculate(String input) {

        if (input.isEmpty()){
            throw new IllegalArgumentException("Invalid input. Please provide a non-empty string");
        }

        String separators;

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
                    throw new IllegalArgumentException("Invalid input. Please enter a positive number only");
                }
                sum += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid delimiter.");
            }
        }

        return sum;
    }
}
