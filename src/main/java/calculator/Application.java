package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("Please enter a string to add.");
        String input = Console.readLine();
        try {
            int result = add(input);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // 문자열 더하는 메소드
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 비어있는 문자열은 0 반환
        }

        String[] numbers = splitText(input); // 문자열 분리
        int result = 0;
        for (String txt : numbers) {
            result += parseNumber(txt); // 각 숫자 더하기
        }
        return result;
    }

    // 문자열을 쪼개는 메소드
    public static String[] splitText(String text) {
        String separator = ",|:"; // 기본 구분자: 쉼표와 콜론

        // 커스텀 구분자 체크
        if (text.startsWith("//")) {
            int delimiterEnd = text.indexOf("\\n"); // "\\n"이 아닌 "\n"을 찾기 위해 수정
            if (delimiterEnd == -1) {
                throw new IllegalArgumentException("Invalid format. A newline is required after the custom delimiter.");
            }
            separator = text.substring(2, delimiterEnd); // 커스텀 구분자 추출
            text = text.substring(delimiterEnd + 2); // 개행 문자 이후 문자열로 업데이트
        }

        return text.split(separator); // 기본 또는 커스텀 구분자로 분리
    }

    // 숫자로 변환하는 메소드
    public static int parseNumber(String text) {
        int num;
        try {
            num = Integer.parseInt(text); // 숫자로 변환
            if (num < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed: " + num);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Non-numeric value found: " + text);
        }
        return num;
    }
}
