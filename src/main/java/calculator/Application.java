package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.print("덧셈할 문자열을 입력해 주세요. : ");
        String input = Console.readLine();
        try {
            int sum = calculateSum(input);
            System.out.println("결과: " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // 계산 메서드
    static int calculateSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열일 경우 0 반환
        }

        // \n -> \\n으로 변환
        input = input.replace("\\n", "\n");

        // 기본 구분자의 경우
        String delimiter = ",|:"; // 기본 구분자
        String numbersPart = input;

        // 커스텀 구분자의 경우
        if (input.startsWith("//")) {
            int customDelimiterStart = input.indexOf("//") + 2; // "//" 다음 인덱스
            int startNum = input.indexOf("\n");

            if (startNum != -1) {
                String customDelimiter = input.substring(customDelimiterStart, startNum).trim().replaceAll("\\s", ""); // 커스텀 구분자
                if (customDelimiter.isEmpty()) {
                    throw new IllegalArgumentException("구분자가 정의되지 않았습니다.");
                }
                delimiter = Pattern.quote(customDelimiter);
                numbersPart = input.substring(startNum + 1); // \n 이후의 부분
            }
        }

        // 구분자 확인
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException("구분자가 정의되지 않았습니다.");
        }

        // 구분자를 기준으로 숫자 추출
        String[] numbers = numbersPart.split(delimiter);

        // 숫자 유효성 검사
        validateNumbers(numbers);

        return sumNumbers(numbers);
    }

    // 숫자 유효성 검사
    private static void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            if (number.trim().isEmpty()) {
                throw new IllegalArgumentException("구분자 사이에 숫자가 없습니다.");
            }

            int num = Integer.parseInt(number.trim());
            if (num < 0) {
                throw new IllegalArgumentException("양수가 아닙니다.");
            }
        }
    }

    // 분리된 숫자 합 계산
    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number.trim());
        }
        return sum;
    }
}
