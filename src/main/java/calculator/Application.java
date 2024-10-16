package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Application {

    private static final String DEFAULT_DELIMITERS = "[,:]";  // 기본 구분자 (쉼표, 콜론)

    public long add(String input) {
        if (input == null || input.isEmpty()) {
            return 0L;
        }

        String[] parts = parseInput(input);
        return sumNumbers(parts);
    }

    private String[] parseInput(String input) {

        if (input.length() > 50) {
            throw new IllegalArgumentException("입력 길이 제한을 초과했습니다.");
        }

        String delimiter = extractDelimiter(input);
        String numbersPart = extractNumbersPart(input);

        // split 결과를 배열로 받음
        String[] parts = numbersPart.split(delimiter, -1);

        for (String part : parts) {
            if (part.isEmpty()) {
                throw new IllegalArgumentException("잘못된 입력 형식: 연속된 구분자는 허용되지 않습니다.");
            }
        }

        return parts;
    }

    private String extractDelimiter(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n"); //input은 문자 그대로 \n 으로 입력되기 때문에 구분자를 찾기 위해서는 \\n 으로 구분해야 한다.

            if (delimiterEndIndex == -1 || delimiterEndIndex == 2) {
                throw new IllegalArgumentException("잘못된 입력 형식: 커스텀 구분자가 누락되었거나 잘못된 형식입니다.");
            }

            // 커스텀 구분자 추출
            String customDelimiter = input.substring(2, delimiterEndIndex);
            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자는 비워둘 수 없습니다.");
            }

            return Pattern.quote(customDelimiter) + "|" + DEFAULT_DELIMITERS; // 정규식에서 안전하게 사용
        }

        return DEFAULT_DELIMITERS;  // 기본 구분자 사용
    }

    private String extractNumbersPart(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            return input.substring(delimiterEndIndex + 2);
        }
        return input.trim();
    }

    private long sumNumbers(String[] numbers) {
        long sum = 0L;  // long 타입으로 초기화

        try {
            for (String number : numbers) {
                long num = parseNumber(number);
                sum = Math.addExact(num, sum);  // long 타입의 덧셈 사용
            }
        } catch (ArithmeticException e) { // 오버플로우 예외 처리
            throw new IllegalArgumentException("덧셈 중 오버플로우가 발생했습니다.", e);
        }
        return sum;
    }

    public static void main(String[] args) {
        Application calculator = new Application();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();  // 사용자로부터 입력을 받음

        try {
            long result = calculator.add(input);
            System.out.println("결과 : " + result);
        } finally {
            Console.close();
        }
    }
}
