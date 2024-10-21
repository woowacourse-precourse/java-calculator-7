package calculator.service;

import java.util.regex.Pattern;

public class CalculatorService {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        if (input.startsWith("//")) {
            return customSum(input);
        }
        String[] numbers = splitString(input);
        return calculateSum(numbers);
    }

    private int customSum(String input) {
        // 구분자 선언 및 '\n' 이후로 숫자 부분 분리
        int newlineIndex = input.indexOf("\n");
        if (newlineIndex == -1) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");  // '\n'이 없는 경우 예외 발생
        }

        // 구분자와 숫자 분리
        String delimiter = input.substring(2, newlineIndex);  // "//" 이후 구분자
        String numbersPart = input.substring(newlineIndex + 1);  // "\n" 이후 숫자들

        // 디버깅용 출력
        System.out.println("구분자: " + delimiter);
        System.out.println("숫자 부분: " + numbersPart);

        // 구분자를 사용하여 숫자들을 분리
        String[] numbers = numbersPart.split(Pattern.quote(delimiter));
        return calculateSum(numbers);
    }

    private String[] splitString(String input) {
        return input.split(",|:");
    }

    private int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }
            sum += num;
        }
        return sum;
    }
}
