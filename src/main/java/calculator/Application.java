package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            // 사용자 입력 받기
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();  // 사용자가 입력한 값 받기
            int result = add(input);  // 계산 실행
            System.out.println("결과 : " + result);  // 결과 출력
        } catch (IllegalArgumentException e) {
            throw e;
//            System.err.println("에러 : " + e.getMessage());
        }
    }

    // 문자열에서 숫자를 추출해 합을 계산하는 메소드
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;  // 빈 문자열 또는 null일 경우 0 반환
        }

        String delimiter = ",|:";  // 기본 구분자: 쉼표와 콜론

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");  // \\n 처리
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다. 커스텀 구분자 이후에는 '\\n'이 필요합니다.");
            }

            delimiter = input.substring(2, delimiterIndex);  // 커스텀 구분자 추출
            input = input.substring(delimiterIndex + 2);  // 숫자 부분만 남기기

            // 커스텀 구분자를 정규식으로 사용할 수 있도록 escape 처리
            delimiter = delimiter.replaceAll("[*+?^${}()|\\[\\]\\\\]", "\\\\$0");
        }

        // 구분자로 문자열 분리 후 숫자 합 계산
        String[] tokens = input.split(delimiter);
        int sum = 0;

        List<String> negatives = new ArrayList<>();  // 음수 값 추적을 위한 리스트
        for (String token : tokens) {
            if (!token.isEmpty()) {
                int number;
                try {
                    number = Integer.parseInt(token);  // 문자열을 숫자로 변환
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + token);
                }

                if (number < 0) {
                    negatives.add(token);  // 음수일 경우 리스트에 추가
                }
                sum += number;  // 합계에 추가
            }
        }

        // 음수 값이 있을 경우 예외 발생
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + String.join(", ", negatives));
        }

        return sum;  // 최종 합계 반환
    }
}
