package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class Calculator {
    private static int defaultSeparator(String input){
        String[] separators = {",", ":"};
        return calculateNumber(input, Arrays.toString(separators));
    }
    private static int calculateNumber(String input, String separator) {
        int sum = 0;

        String [] numbers = input.split(separator);

        for (String number : numbers) {
            int value = Integer.parseInt(number.trim());

            sum += value;
        }

        return sum;
    }
}
