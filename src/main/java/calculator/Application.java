package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        if (input.isEmpty()) { // 빈 문자열 입력 시 0 출력
            System.out.println("결과 : 0");
            return;
        }

        String delimeter = ",|:";

        String[] values = input.split(delimeter);

        int sum = 0;
        for (String value : values) {
            if (!isPositiveInteger(value)) {
                throw new IllegalArgumentException();
            }
            sum += Integer.parseInt(value);
        }

        System.out.println("결과 : " + sum);
    }

    // 문자열을 양수로 변환할 수 있는지 체크
    private static boolean isPositiveInteger(String s) {
        try {
            // parseInt 안되면 NumberFormatException 발생
            int number = Integer.parseInt(s);
            return number > 0;  // 양수만 통과
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
