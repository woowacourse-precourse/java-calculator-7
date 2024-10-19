package calculator;

import camp.nextstep.edu.missionutils.Console;

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

        String delimiter = ",|:";  // 기본 구분자 쉼표(,)와 콜론(:)
        String numbers = input;

        // 커스텀 구분자가 있는지 확인하고 처리
        if (checkCustomDelimiter(input)) {
            delimiter = addCustomDelimiter(input);  // 커스텀 구분자 추가
            numbers = extractNumbers(input);  // 숫자 부분 추출
        }

        // 문자열을 구분자를 기준으로 분리하고 합을 구함
        return getSum(splitString(numbers, delimiter));
    }

    private static int getSum(Object o) {
    }

    private static Object splitString(String numbers, String delimiter) {
    }

    private static String extractNumbers(String input) {
    }

    private static String addCustomDelimiter(String input) {
    }

    private static boolean checkCustomDelimiter(String input) {
    }


    private static void printOutput(int result) {
    }

}
