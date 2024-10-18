package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();
        Calculator calculator = new Calculator(input);

//        try {
//            stringCalculator.checkInput();
//        } catch (IllegalArgumentException e) {
//            throw new IllegalArgumentException("잘못된 입력");
//            e.printStackTrace();
//            System.exit(1);
//        }
        calculator.checkInput();
        calculator.splitInput();
        calculator.addNumbers();
        System.out.println("결과 : " + calculator.getSum());
    }
}
