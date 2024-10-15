package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

//        String input = Console.readLine();
        String input = "3;2";

        Calculator calculator = new Calculator(input);
        int result = calculator.calculate();
        System.out.println(result);
    }
}
