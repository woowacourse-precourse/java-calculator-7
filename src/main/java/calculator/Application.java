package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();  // 예외 발생 시 스택 트레이스 출력
        }
    }

    public static int add(String input) {
        System.out.println("입력된 문자열: " + input);

        if (input == null || input.isEmpty()) {
            System.out.println("빈 문자열 또는 null 입력");
            return 0;
        }

        String delimiter = ",|:";  // 기본 구분자 (쉼표 또는 콜론)

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            if (delimiterIndex == -1 || delimiterIndex == 2) {  // \n이 없거나 커스텀 구분자가 없는 경우
                throw new IllegalArgumentException("커스텀 구분자가 잘못되었습니다.");
            }
            delimiter = input.substring(2, delimiterIndex);  // 커스텀 구분자 추출
            input = input.substring(delimiterIndex + 1);  // 커스텀 구분자 이후의 입력값 추출
            System.out.println("커스텀 구분자: " + delimiter);
        }

        System.out.println("구분자로 분리된 입력 문자열: " + input);

        String[] tokens = input.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) {
                try {
                    int number = Integer.parseInt(token.trim());
                    System.out.println("분리된 숫자: " + number);
                    if (number < 0) {
                        throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                    }
                    sum += number;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + token);
                }
            }
        }
        return sum;
    }
}
