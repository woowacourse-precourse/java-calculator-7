package calculator;

import java.util.regex.Pattern;

public class StringCalculate {

    public int calculate(String input) {
        // 입력 값 디버깅
        input = input.replace("\\n", "\n");

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            return sumWithCustomDelimiter(input, findDelimiter(input));
        } else if (input.isEmpty()) {
            return 0;
        } else {
            // 기본 구분자(쉼표와 콜론)로 처리
            return sumWithDefaultDelimiter(input);
        }
    }

    private String findDelimiter(String input) {
        // "\n"이 있는 위치 찾기
        int delimiterEndIndex = input.indexOf("\n");

        // "\n"이 없으면 예외 처리
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다. //구분자\\n 형식을 사용하세요.");
        }

        // "//"와 "\n" 사이의 구분자 추출
        String customDelimiter = input.substring(2, delimiterEndIndex);

        return customDelimiter;
    }
    private int sumWithCustomDelimiter(String input, String customDelimiter) {
        // "\n" 이후의 숫자 부분 추출
        int delimiterEndIndex = input.indexOf("\n");
        String numberPart = input.substring(delimiterEndIndex + 1).trim();

        // 디버깅용: 숫자 부분 출력
//        System.out.println("Number part: " + numberPart);

        // 구분자를 기준으로 숫자 분리
        String[] numbers = numberPart.split(Pattern.quote(customDelimiter));

        return sum(numbers);
    }

    private int sumWithDefaultDelimiter(String input) {
        String[] numbers = input.split("[,:]");
        return sum(numbers);
    }



    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            int parsedNumber = Integer.parseInt(number.trim());

            if (parsedNumber < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + parsedNumber);
            }
            total += parsedNumber;
        }
        return total;
    }
}
