package calculator;
import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        SumCalculator calculator = new SumCalculator();
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String userInput = Console.readLine();
        calculator.startCalculator(userInput);




    }
}
