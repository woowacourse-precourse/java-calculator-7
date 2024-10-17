package calculator;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = sc.nextLine();

        try {
            int result = calculate(input);
            System.out.println("결과: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int calculate(String input) {
        // 입력이 null이거나 비어있으면 0을 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자 설정
        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            if (delimiterIndex != -1) { // 구분자 설정이 올바른지 확인
                delimiter = input.substring(2, delimiterIndex); // 커스텀 구분자 추출
                input = input.substring(delimiterIndex + 1); // 숫자 부분만 추출
            } else {
                throw new IllegalArgumentException("구분자 설정이 잘못되었습니다!");
            }
        }

        // 입력 문자열을 구분자로 나누기
        String[] splits = input.split(delimiter); // delimiter를 사용하여 문자열 분리
        int sum = 0;

        // 숫자를 하나씩 합산
        for (String split : splits) {
            try {
                int number = Integer.parseInt(split.trim()); // 문자열을 숫자로 변환
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                }
                sum += number; // 양수일 경우 합산
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다!");
            }
        }

        return sum; // 최종 합계 반환
    }
}
