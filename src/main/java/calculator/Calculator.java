package calculator;

import java.util.regex.Pattern;

public class Calculator {

    public int calculate(String input) {
        int result = 0;

        // 쉼표, 콜론으로 숫자 분리
        if (input.contains(",") || input.contains(":")) {
            String[] numbers = defaultDelimiter(input);
            result = sumNumbers(numbers);
        }

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            String[] numbers = CustomDelimiter(input);
            result = sumNumbers(numbers);
        }

        return result;
    }

    // 쉼표, 콜론으로 숫자를 분리하는 메서드
    private String[] defaultDelimiter(String input) {
        return input.split("[,:]");
    }

    // 커스텀 구분자로 숫자를 분리하는 메서드
    private String[] CustomDelimiter(String input) {
        int idx = input.indexOf("\\n");
        if (idx == -1) {
            throw new IllegalArgumentException();
        }
        String customDelimiter = input.substring(2, idx); // 구분자 추출
        System.out.println("customDelimiter = " + customDelimiter);
        String str = input.substring(idx + 2); // \n 이후 부분 추출
        String escapedDelimiter = Pattern.quote(customDelimiter);
        System.out.println("escapedDelimiter = " + escapedDelimiter);
        return str.split(escapedDelimiter); // 이스케이프된 구분자로 분리
    }

    // 분리된 문자열을 숫자로 바꿔 더하는 메서드
    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = convertParseInt(number);
            checkMinus(num);
            sum += num;
        }
        return sum;
    }

    //분리한 String을 숫자로 바꾸며 빈칸은 0으로 바꾸는 메서드
    private int convertParseInt(String number) {
        if (number == null || number.isBlank()) {
            return 0;
        }
        return Integer.parseInt(number);
    }

    // 음수 체크
    private void checkMinus(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }
    }
}