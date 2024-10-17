package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputString = "";

        // x를 눌러 종료
        while (!inputString.equalsIgnoreCase("X")) {
            System.out.println("숫자를 입력해 주세요.\n(H : 도움말, X : 프로그램 종료 | 기본 구분자 : ',' 또는 ':')");
            inputString = Console.readLine();

            // h를 눌러 도움말 호출
            if (inputString.equalsIgnoreCase("H")) {
                new Helper();
                System.out.println();
            } else if (inputString.isEmpty()) {
                System.out.println("결과 : 0");
            } else {
               new Calculator(inputString);
            }

        }
    }
}
