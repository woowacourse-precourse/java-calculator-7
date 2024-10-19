package calculator;

import java.util.Arrays;

public class Calculation {
    public String[] filterNumbers(String input) {
        Parser parser = new Parser();

        String[] parseredString = parser.split(input);

        return Arrays.stream(parseredString)
                .map(number -> number.replaceAll("[^0-9]", ""))
                .filter(number -> !number.isEmpty())
                .toArray(String[]::new);
    }

    public int sumNumbers(String[] exactNumbers) {
        int result = 0;

        for (String exactNumber : exactNumbers) {
            result += Integer.parseInt(exactNumber);
        }

        return result;
    }
}
