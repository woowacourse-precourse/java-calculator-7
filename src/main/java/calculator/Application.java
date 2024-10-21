package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // 사용자 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            // 문자열 덧셈 계산
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            // 예외 발생 시 메시지 출력
            System.out.println(e.getMessage());
            throw e; // 예외를 다시 던져 테스트에서 예외가 발생하도록 합니다.
        }
    }

    // 문자열 덧셈 계산 로직
    public static int add(String input) {
        // 빈 문자열 또는 null일 경우 0 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 커스텀 구분자가 있는지 확인 (정규식: "//" 뒤에 구분자와 "\n" 뒤의 숫자들 매칭)
        Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
        Matcher matcher = pattern.matcher(input);

        String delimiter = ",|:";  // 기본 구분자 쉼표와 콜론
        if (matcher.matches()) {
            // 첫 번째 그룹: 커스텀 구분자
            delimiter = matcher.group(1);
            System.out.println("커스텀 구분자: " + delimiter);

            // 두 번째 그룹: 숫자 목록
            input = matcher.group(2);
            System.out.println("숫자 (처리 전): " + input);
        }

        // 줄바꿈 문자를 제거하여 숫자 문자열 처리
        input = input.replace("\\n", "");  // 문자 그대로의 \n 제거
        System.out.println("숫자 (처리 후): " + input);

        // 커스텀 구분자와 기본 구분자를 함께 처리
        String[] numberArray = input.split("[,|:|" + Pattern.quote(delimiter) + "]");

        return sum(numberArray);  // 합산 결과 반환
    }

    // 숫자 합산 처리 메서드
    private static int sum(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            if (number.isEmpty()) {
                continue;  // 빈 문자열 무시
            }

            try {
                int n = Integer.parseInt(number.trim());  // 문자열을 정수로 변환
                if (n < 0) {
                    // 음수일 경우 예외 발생
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + n);
                }
                result += n;  // 합산
            } catch (NumberFormatException e) {
                // 잘못된 숫자 형식이 있을 경우 예외 발생
                throw new IllegalArgumentException("숫자 형식이 잘못되었습니다: " + number);
            }
        }
        return result;
    }
}
