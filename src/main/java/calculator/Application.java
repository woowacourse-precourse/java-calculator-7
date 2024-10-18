package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;

public class Application {
    public static void main(String[] args) {
        ApplicationViewer.outputLine("덧셈할 문자열을 입력해 주세요.");
        String givenInput = Console.readLine();
        Calculator<BigInteger> calculator = new StringSummationCalculator();
        BigInteger result = calculator.calculate(givenInput);

        ApplicationViewer.outputLine("결과 : "+result);
    }
}
