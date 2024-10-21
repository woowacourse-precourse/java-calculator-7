package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = sc.nextLine();

        int result = calc(input);
        System.out.println("결과 : " + result);

        sc.close();
    }

    public static int calc(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int result = 0;
        String[] numbers;

        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다. 구분자와 숫자 사이에 \\n이 필요합니다.");
            }
            String delimiter = input.substring(2, newlineIndex);
            String numbersPart = input.substring(newlineIndex + 2);
            numbers = numbersPart.split(delimiter);

            validateNumbers(numbers);
        } else {
            numbers = input.split("[,:]");
            validateNumbers(numbers);  // 기본 구분자에서도 숫자 검증
        }

        for (String num : numbers) {
            result += Integer.parseInt(num.trim());
        }
        return result;
    }

    private static void validateNumbers(String[] numbers) {
        for (String num : numbers) {
            if (!num.matches("-?\\d+")) {  // 숫자가 아닌 값 검증
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + num);
            }
            if (Integer.parseInt(num.trim()) < 0) {  // 음수 처리
                throw new IllegalArgumentException("음수가 포함되어 있습니다: " + num);
            }
        }
    }
}