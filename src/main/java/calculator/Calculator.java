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
        String str = input.substring(idx + 2); // \n 이후 부분 추출
        String escapedDelimiter = Pattern.quote(customDelimiter);
        return str.split(escapedDelimiter); // 이스케이프된 구분자로 분리
    }

    // 분리된 문자열을 숫자로 바꿔 더하는 메서드
    private int sumNumbers(String[] numbers) {
        CheckMinus validator = new CheckMinus();
        ConvertParseInt parser = new ConvertParseInt();
        int sum = 0;
        for (String number : numbers) {
            int num = parser.convertParseInt(number);
            validator.checkMinus(num);
            sum += num;
        }
        return sum;
    }
}