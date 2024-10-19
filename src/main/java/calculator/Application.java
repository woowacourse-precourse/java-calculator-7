package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {

        String input = getInput();

        int result = processInput(input);

        printOutput(result);
    }

    private static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    private static int processInput(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int sum;
        int[] numbers;
        String delimiter = ",|:";

        // 커스텀 구분자가 있는지 확인하고 처리
        if (checkCustomDelimiter(input)) {
            delimiter = addCustomDelimiter(input);
        }

        numbers = extractNumbers(input, delimiter);
        sum = Arrays.stream(numbers).sum();
        return sum;
    }


    private static boolean checkCustomDelimiter(String input) {
    }
    private static String addCustomDelimiter(String input) {
    }
    private static int[] extractNumbers(String input) {
    }

    private static void printOutput(int result) {
    }

}
