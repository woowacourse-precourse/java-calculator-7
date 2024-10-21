package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        // 사용자 입력
        String input = readLine();
        // 덧셈 결과
        int result = add(input);
        // 결과 출력
        System.out.println("결과 : "+result);
    }

    public static int add(String input) {
        // 1. 빈 문자열 또는 null 입력 시 0을 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 커스텀 구분자가 있는 경우
        // 3. 커스텀 구분자를 지정하여 숫자의 합을 반환
        if (input.startsWith("//")) {
            String delimiter = input.substring(2, 3);  // 커스텀 구분자 추출
            input = input.substring(5);  // 숫자 부분 추출 (//구분자\n 이후부터)

            // 커스텀 구분자로 숫자 분리
            String[] numbers = input.split(delimiter);
            int sum = 0;
            for (String number : numbers) {
                int num = Integer.parseInt(number);

                // 4. 잘못된 입력 시 IllegalArgumentException을 발생
                if (num < 0) {
                    throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
                }
                sum += num;
            }
            return sum;
        } 
        else {
        // 2. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열의 숫자 합을 반환
            String[] numbers = input.split("[,|:]");
            int sum = 0;
            for (String number : numbers) {
                int num = Integer.parseInt(number);
                // 4. 잘못된 입력 시 IllegalArgumentException을 발생
                if (num < 0) {
                    throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
                }
                sum += num;
            }
            return sum;
        }
    }
}
