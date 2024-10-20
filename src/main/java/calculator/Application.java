package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();

            System.out.println("덧셈할 문자열을 입력해 주세요.");

            String input = Console.readLine();

            calculator.manageAdd(input);

            System.out.println("결과 : " + calculator.getSum());
            calculator = null; //참조 해제

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
//                System.err.println("예외 발생: " + e.getMessage());
//                break;

        }

    }
}
