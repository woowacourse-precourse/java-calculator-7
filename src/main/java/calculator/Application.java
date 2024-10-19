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
        String delimiter = ",|:";  // 기본 구분자

        // 커스텀 구분자가 있는지 확인하고 처리
        if (checkCustomDelimiter(input)) {
            delimiter += "|" + addCustomDelimiter(input);  // 기본 구분자에 커스텀 구분자 추가
        }

        // 문자열을 구분자로 분리하여 숫자 배열 추출
        numbers = extractNumbers(input, delimiter);
        sum = Arrays.stream(numbers).sum();  // 숫자들 합 계산
        return sum;  // 합 반환
    }


    private static boolean checkCustomDelimiter(String input) {
        return input.startsWith("//");
    }
    private static String addCustomDelimiter(String input) {
        int endIndex = input.indexOf("\n");
        return input.substring(2, endIndex);
    }
    private static int[] extractNumbers(String input, String delimiter) {
        String[] tokens = input.split(delimiter);  // 구분자를 사용해 문자열 분리
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void printOutput(int result) {
    }

}
