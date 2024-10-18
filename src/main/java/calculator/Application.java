package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static String getInput() {
        printMessage("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    private static void printMessage(String output) {
        System.out.println(output);
    }

    private static void printError(String errorMessage) {
        System.err.println(errorMessage);
    }

    private static void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    private static List<String> getDefaultDelimiters() {
        List<String> delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");

        return delimiters;
    }

    private static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//") && input.contains("\n");
    }

    private static String extractNumbers(String input) {
        int delimiterEndIndex = input.indexOf("\n");
        return input.substring(delimiterEndIndex + 1);
    }

    private static List<String> extractAndValidateCustomDelimiter(String input) {
        int delimiterEndIndex = input.indexOf("\n");

        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException("잘못된 형식의 커스텀 구분자입니다.");
        }

        String customDelimiter = input.substring(2, delimiterEndIndex);

        if (customDelimiter.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 한 문자여야 합니다.");
        }

        if (customDelimiter.equals(",") || customDelimiter.equals(":")) {
            throw new IllegalArgumentException("기본 구분자와 중복되는 커스텀 구분자는 사용할 수 없습니다.");
        }

        List<String> delimiters = getDefaultDelimiters();
        delimiters.add(customDelimiter);
        return delimiters;
    }
}
