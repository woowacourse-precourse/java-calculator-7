package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
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
        List<Integer> parsedNumbers = new ArrayList<>();
        for (String number : input.split("[,:]")) {
            parsedNumbers.add(Integer.parseInt(number.trim()));
        }
        return parsedNumbers;
    }
}
