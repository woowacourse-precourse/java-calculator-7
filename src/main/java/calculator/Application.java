package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 4. 에러 처리
        try {
            // TODO: 프로그램 구현
            // 1. 입력
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();

            // 3. 커스텀 구분자 처리
            if (input.startsWith("//")) {
                int delimiterEndIndex = input.indexOf("\\n");
                if (delimiterEndIndex != -1) {
                    String customDelimiter = input.substring(2, delimiterEndIndex);
                    input = input.substring(delimiterEndIndex + 2);
                    input = input.replace(customDelimiter, ",");
                }
            }

            //  2. 기본 구분자로 문자열 분리, 결과 합산
            String[] numbers = input.split("[,:]");

            int sum = 0;
            for (String number : numbers) {
                String trimmedNumber = number.trim();
                if (!trimmedNumber.matches("\\d+")) {
                    throw new IllegalArgumentException("유효하지 않은 입력 값: " + trimmedNumber);
                }
                sum += Integer.parseInt(trimmedNumber);
            }

            System.out.println("결과 : "+sum);

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }
}