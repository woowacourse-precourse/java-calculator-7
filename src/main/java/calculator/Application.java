package calculator;

import java.util.Arrays;

public class Application {
    public static String[] separators = {",", ":"};

    public static void main(String[] args) {

    }

    public static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static int[] extractNumbers(String input, String[] separators) {
        String separatorsRegex = String.join("|", separators);

        return Arrays.stream(input.split(separatorsRegex)).mapToInt(Integer::parseInt).toArray();
    }
}
