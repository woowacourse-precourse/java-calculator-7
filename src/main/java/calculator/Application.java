package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String formula = "";

        while (!formula.equalsIgnoreCase("X")) {
            System.out.println("숫자를 입력해 주세요.\n(H : 도움말, X : 프로그램 종료 | 기본 구분자 : ',' 또는 ':')");
            formula = Console.readLine();
            if (formula.equalsIgnoreCase("H")) {
                Helper helper = new Helper();
                System.out.println();
                continue;
            } else if (formula == "") {
                System.out.println("결과 : 0");
            } else {
                Calculator calculator = new Calculator(formula);
            }
        }
    }
}
