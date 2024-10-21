package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            // 1. 사용자로부터 입력을 받는 기능
            String input = Console.readLine();
            System.out.println("입력받은 문자열: " + input);

            // 2. 입력된 문자열을 파싱하는 기능
            String delimiter = ",|:";
            String numbers = input;

            // 커스텀 구분자 확인
            if (input.startsWith("//")) {
                int delimiterIndex = input.indexOf("\n");
                if (delimiterIndex != -1) {
                    delimiter = input.substring(2, delimiterIndex);
                    numbers = input.substring(delimiterIndex + 1);
                } else {
                    throw new IllegalArgumentException("잘못된 구분자 형식입니다. 구분자는 //와 \\n 사이에 있어야 합니다.");
                }
            }

            System.out.println("사용된 구분자: " + delimiter);
            System.out.println("파싱할 숫자 문자열: " + numbers);

            // 3. 분리된 문자열에서 숫자를 추출하는 기능
            String[] numberArray = numbers.split(delimiter);
            System.out.println("추출된 숫자들: ");
            for (String num : numberArray) {
                System.out.println(num);
            }

            // 4. 추출된 숫자들의 합을 계산하는 기능
            int sum = 0;
            for (String num : numberArray) {
                if (!num.matches("\\d+")) {  // 숫자가 아닌 값이 들어오면 예외 처리
                    throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + num);
                }
                sum += Integer.parseInt(num);
            }

            // 5. 결과를 출력하는 기능
            System.out.println("최종 결과: " + sum);

        } catch (IllegalArgumentException e) {
            System.out.println("에러 발생: " + e.getMessage());
            System.exit(1);  // 애플리케이션 종료
        }
    }
}
