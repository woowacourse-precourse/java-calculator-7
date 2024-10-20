package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try{
//            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
//            String input = "//;\\n1";
            Calculator calculator = new Calculator(input);
            System.out.println("결과 : " + calculator.getResult());
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }

//        String input = "//;\\n1";
//        Calculator calculator = new Calculator(input);
//        System.out.println(calculator.getResult());
    }
}
