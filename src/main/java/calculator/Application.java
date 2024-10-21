package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); // 사용자로부터 입력 받음

        int result = add(input);
        System.out.println("결과 : " + result); // 결과 출력
    }

    // 입력된 문자열에서 숫자를 추출하여 더하는 함수
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열일 경우 0 반환
        }

        String delimiter = ",|:"; // 기본 구분자(쉼표, 콜론)

        String[] numbers = input.split(delimiter); // 구분자로 문자열 분리
        return sum(numbers); // 숫자 합 계산
    }

    // 문자열 배열을 더해서 합을 반환하는 함수
    private static int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number.trim()); // 음수 체크 및 정수 변환
            total += num;
        }
        return total;
    }
}
