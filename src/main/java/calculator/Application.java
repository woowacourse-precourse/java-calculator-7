package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성
        System.out.println("덧셈할 문자열을 입력해 주세요:");
        String input = scanner.nextLine(); // 사용자 입력 받기

        try {
            int result = addNumbers(input);
            System.out.println("결과: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("오류: " + e.getMessage());
        } finally {
            scanner.close(); // 리소스 해제
        }
    }

    public static int addNumbers(String input) {
        // 기본적으로 빈 문자열일 경우 0 반환
        if (input.isEmpty()) {
            return 0;
        }

        // 따옴표로 둘러싸인 부분 추출
        String[] parts = input.split(",", 2);
        String numbers = parts.length > 1 ? parts[1].trim() : ""; // 두 번째 부분이 숫자 부분

        // 구분자 설정
        String delimiter = ",|:";

        // 구분자로 숫자 분리
        String[] splitNumbers = numbers.split(delimiter);
        List<Integer> validNumbers = new ArrayList<>();
        int sum = 0;

        for (String numStr : splitNumbers) {
            // 숫자 스트링에서 공백 제거
            numStr = numStr.trim();
            if (numStr.isEmpty()) {
                continue; // 빈 문자열은 무시
            }

            try {
                // 숫자로 변환
                int num = Integer.parseInt(numStr);
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
                }
                validNumbers.add(num);
                sum += num; // 합계 계산
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식: " + numStr);
            }
        }

        return sum;
    }
}