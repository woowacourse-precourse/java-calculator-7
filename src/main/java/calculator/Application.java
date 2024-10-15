package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String input = getUserInput();

        try {
            int result;
            if (input.startsWith("//")) {
                result = customCalculateSum(input);
            } else {
                result = defaultCalculateSum(input);
            }
            System.out.println("결과: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }
    }

    // 01. 사용자 입력 기능
    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("덧셈할 문자열을 입력해 주세요.\n");
        String input = scanner.nextLine().trim();

        return input.isEmpty() ? "" : input;
    }

    // 02. 기본 구분자 처리 기능
    private static int defaultCalculateSum(String input) {
        String[] numbers = input.split("[,:]");
        return sumNumbers(numbers);
    }

    // 03. 커스텀 구분자 처리 기능
    private static int customCalculateSum(String input){
        int startDelimiterIndex = input.indexOf("//");
        int endDelimiterIndex = input.indexOf("\\n");

        // 올바른 구분자 형식 확인
        if (startDelimiterIndex == -1 || endDelimiterIndex == -1 || startDelimiterIndex + 2 >= endDelimiterIndex) {
            throw new IllegalArgumentException("올바른 구분자 형식이 아닙니다.");
        }

        // 커스텀 구분자 추출
        String customDelimiter = escapeSpecialCharacters(input.substring(startDelimiterIndex + 2, endDelimiterIndex).trim());

        // 숫자 문자열 추출
        String numbers = input.substring(endDelimiterIndex + 2).trim(); // "\n" 이후의 숫자 문자열

        // 커스텀 구분자로 문자열을 분리
        String[] numberArray = numbers.split(customDelimiter);

        return sumNumbers(numberArray);
    }

    // 정규 표현식 특수문자 처리
    private static String escapeSpecialCharacters(String delimiter) {
        return delimiter.replaceAll("([\\[\\]{}()*+?^$|.])", "\\\\$1");
    }


    // 공통적인 숫자 덧셈 기능
    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            try {
                sum += Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자가 포함되어 있습니다.");
            }
        }
        return sum;
    }
}
