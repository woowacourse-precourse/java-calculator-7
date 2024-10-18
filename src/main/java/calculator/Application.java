package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            // 사용자에게 입력 요청
            System.out.println("덧셈할 문자열을 입력하세요.");

            // 콘솔에서 입력받은 문자열을 input에 저장
            String input = Console.readLine();

            // 입력받은 문자열을 분리 후 숫자로 변환
            List<Integer> numbers = StringCalculator.splitAndConvert(input);

            // 숫자로 변환된 리스트의 총합 구하기
            int sum = StringCalculator.sumNumber(numbers);

            // 결과 출력
            System.out.println("결과 : " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
