package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        List<String> numbers = NumberString.parse(input);
        BigInteger result = StringCalculator.calculate(numbers);

        System.out.println("결과 : " + result);
    }
}
