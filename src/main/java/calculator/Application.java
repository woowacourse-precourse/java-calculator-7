package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String customDelimiter = extractCustomDelimiter(input); // 커스텀 구분자 추출
        String numbersPart = extractNumbersPart(input); // 커스텀 구분자 지정 문자 제외한 부분 추출
        System.out.println("nums: " + numbersPart);

        String regex = "[," + customDelimiter + ":]";
        String[] numbers = numbersPart.split(regex);
        for (String number : numbers) {
            System.out.println(number);
        }
    }

    public static String extractNumbersPart(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex != -1 && delimiterEndIndex > 2) {
                return input.substring(delimiterEndIndex + 2);
            } else {
                return input; // \n이 없으면 전체 문자열을 반환
            }
        }
    }

    public static String extractCustomDelimiter(String input) {
        // 첫 2글자가 "//"로 시작하는지 확인
        if (input.startsWith("//")) {
            // \n 이전의 부분에서 커스텀 구분자를 추출
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex != -1 && delimiterEndIndex > 2) {
                return input.substring(2, delimiterEndIndex);
            }
        }
        // 커스텀 구분자가 없으면 빈 문자열 반환
        return "";
    }
}
