package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        int result = calculateSum(input);
        System.out.printf("결과 : %d\n", result);
    }

    public static int calculateSum(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        List<Integer> parsedNumbers = parseInput(input);
        int sum = 0;
        for (int number : parsedNumbers) {
            if (number <= 0) {
                throw new IllegalArgumentException();
            }
            sum += number;
        }
        return sum;
    }

    public static List<Integer> parseInput(String input) {
        String delimiter = "[,:]";

        try {
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
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }
}
