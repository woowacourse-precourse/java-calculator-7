package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.controller.CalculatorController;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
//        CalculatorController c = new CalculatorController();
//        c.calculateString();

        try {
            // 1. 사용자로부터 입력을 받는 기능
            String input = readLine();
            // System.out.println("입력받은 문자열: " + input);

            // 7. 메인 로직을 구현하는 기능 - 빈 문자열 처리
            if (input.isEmpty()) {
                System.out.println("최종 결과: 0");
                return;
            }

            // 2. 입력된 문자열을 파싱하는 기능
            String delimiter = ",|:";  // 기본 구분자 설정
            String numbers = input;

            // 7. 메인 로직을 구현하는 기능 - 커스텀 구분자 체크
            if (input.startsWith("//")) {
                int delimiterIndex = input.indexOf("\n");
                if (delimiterIndex != -1) {
                    delimiter = input.substring(2, delimiterIndex);  // 커스텀 구분자 추출
                    numbers = input.substring(delimiterIndex + 1);  // 구분자 이후의 숫자 추출
                } else {
                    throw new IllegalArgumentException("[ERROR] 잘못된 구분자 형식입니다.");
                }
            }

            // System.out.println("사용된 구분자: " + delimiter);
            // System.out.println("파싱할 숫자 문자열: " + numbers);

            // 3. 분리된 문자열에서 숫자를 추출하는 기능
            String[] numberArray = numbers.split(delimiter);

            // 4. 추출된 숫자들의 합을 계산하는 기능
            int sum = 0;
            for (String num : numberArray) {
                if (!num.matches("\\d+")) {  // 숫자가 아닌 값이 들어오면 예외 처리
                    throw new IllegalArgumentException("[ERROR] 양수를 입력해야 합니다.");
                }
                sum += Integer.parseInt(num);  // 숫자로 변환하여 합계 계산
            }

            // 5. 결과를 출력하는 기능
            System.out.println(sum);

        } catch (IllegalArgumentException e) {
            // 6. 예외 처리 기능
            System.out.println("에러 발생: " + e.getMessage());
            System.exit(1);  // 애플리케이션 종료
        }

    }
}
