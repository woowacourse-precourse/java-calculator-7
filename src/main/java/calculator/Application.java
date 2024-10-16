package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String formula = "";

        // x를 눌러 종료
        while (!formula.equalsIgnoreCase("X")) {
            System.out.println("숫자를 입력해 주세요.\n(H : 도움말, X : 프로그램 종료 | 기본 구분자 : ',' 또는 ':')");
            formula = Console.readLine();

            // h를 눌러 도움말 호출
            if (formula.equalsIgnoreCase("H")) {
                Helper helper = new Helper();
                System.out.println();
            } else if (formula == "") {
                System.out.println("결과 : 0");
            } else {
                Calculator calculator = new Calculator(formula);
            }
        }
    }
}
