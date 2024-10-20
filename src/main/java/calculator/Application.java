package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    // 문자열에서 숫자를 추출하고 합을 계산하는 함수
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열일 경우 0 반환
        }

        String delimiter = ",|:"; // 기본 구분자 쉼표와 콜론
        String numbers = input;

        // 커스텀 구분자가 있는 경우
        if (input.startsWith("//")) {
            // "//"와 "\n" 사이의 구분자를 추출
            int delimiterStart = input.indexOf("//") + 2; // "//" 이후
            int delimiterEnd = input.indexOf("\\n");
            if (delimiterEnd != -1) {
                delimiter = input.substring(delimiterStart, delimiterEnd); // 구분자 추출
                numbers = input.substring(delimiterEnd + 2); // 구분자 뒤의 숫자 문자열
            } else {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
        }

        // 구분자를 기준으로 숫자 분리
        String[] tokens = numbers.split(delimiter);

        int sum = 0;
        for (String token : tokens) {
            try {
                sum += Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
            }
        }
        return sum;
    }
    public static void main(String[] args) {

        // 사용자로부터 문자열 입력받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int result = add(input);
            System.out.println("결과 :  " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("에러: " + e.getMessage());
        }
    }
}
