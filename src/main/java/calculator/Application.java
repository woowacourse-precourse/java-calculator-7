package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int sumNumbers(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be empty");
        }

        String delimiter = "[,:]"; // 기본 구분자
        String numbers = input;

        // 커스텀 구분자가 있는지 확인
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("Custom delimiter must end with '\\n'");
            }
            delimiter = input.substring(2, delimiterEndIndex); // 커스텀 구분자 추출
            numbers = input.substring(delimiterEndIndex + 1); // 실제 숫자 문자열
        }

        // 커스텀 구분자를 포함하여 문자열을 분리
        String[] parts = numbers.split(delimiter);
        int sum = 0;

        for (String part : parts) {
            part = part.trim();
            if (part.isEmpty()) {
                throw new IllegalArgumentException("Empty value detected between delimiters");
            }

            try {
                sum += Integer.parseInt(part); // 숫자 변환 시도
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid number format: " + part);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요:");
            String input = Console.readLine();
            int result = sumNumbers(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Error : " + e.getMessage());
            //System.exit(1); // 애플리케이션 종료
        }
    }
}