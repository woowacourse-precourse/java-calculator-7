package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        // System.out.println("입력된 문자열 : " + input); // 입력된 문자열 확인용 코드

        private static void validateInput(String input) {
            // 유효성 case 1: "//"로 시작하는 경우
            if (input.startsWith("//")) {
                // 3번 인덱스가 '\'인지, 4번 인덱스가 'n'인지 확인
                if (input.charAt(3) != '\\' || input.charAt(4) != 'n') {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
                // 2번 인덱스 위치에 숫자가 있는 경우 예외 처리
                if (Character.isDigit(input.charAt(2))) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
            } else { // 유효성 case 2: "//"로 시작하지 않는 경우
                for (char c : input.toCharArray()) {
                    if (!Character.isDigit(c) && c != ',' && c != ':') {
                        throw new IllegalArgumentException("잘못된 입력입니다.");
                    }
                }
            }
        }

    }
}
