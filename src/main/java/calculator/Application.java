package calculator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    // 메인 메서드: 프로그램의 시작점
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine(); // 사용자 입력 받기
        try {
            int result = addNumbers(input); // 계산 결과
            System.out.println("결과 : " + result); // 출력
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 예외 발생 시 메시지 출력
        }
    }

    private static int addNumbers(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자 설정
        if (input.startsWith("//")) { // 커스텀 구분자 처리
            int newlineIndex = input.indexOf("\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력입니다."); // '\n'이 없으면 예외 발생
            }
            delimiter = input.substring(2, newlineIndex); // 커스텀 구분자 추출
            input = input.substring(newlineIndex + 1); // 나머지 문자열 추출
        }

        // 입력 문자열을 구분자로 분리
        String[] numbers;
        if(input.contains(delimiter)) {
            numbers = input.split(delimiter);
        }
        else numbers = new String[]{input};
        int sum = 0;

        for (String number : numbers) {
            if (number.trim().isEmpty()) {
                continue; // 빈 문자열 무시
            }

            try {
                int num = Integer.parseInt(number.trim()); // 숫자로 변환
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num); // 음수 예외 처리
                }
                sum += num; // 합산
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식: " + number); // 형식 예외 처리
            }
        }

        return sum; // 최종 합계 반환
    }
}
