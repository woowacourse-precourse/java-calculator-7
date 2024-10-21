package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        int result = calculateSum(input);
    }

    public static int calculateSum(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        List<Integer> parsedNumbers = parseInput(input);
        return -1;
    }

    public static List<Integer> parseInput(String input) {
        String delimiter = "[,:]";

        if (input.startsWith("//")) {
            int newLineIndex = input.indexOf("\\n");
            delimiter = input.substring(2, newLineIndex);
            input = input.substring(newLineIndex + 2);
        }

        List<Integer> parsedNumbers = new ArrayList<>();
        for (String number : input.split(delimiter)) {
            parsedNumbers.add(Integer.parseInt(number.trim()));
        }
        return parsedNumbers;
    }
}
