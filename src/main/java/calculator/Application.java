package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 문자열 입력받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        // 아무것도 입력하지 않은 경우
        if (str.isEmpty()) {
            System.out.println(0);
        }

        // 숫자가 포함되어 있지 않은 경우
        if (!str.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("숫자를 포함하여 입력해 주세요.");
        }

        // 0이 포함되어 있는 경우
        if (str.contains("0")) {
            throw new IllegalArgumentException("0을 제외한 양수를 입력해 주세요.");
        }
    }
}
