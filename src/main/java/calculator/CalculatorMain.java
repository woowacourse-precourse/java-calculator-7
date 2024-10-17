package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;

public class CalculatorMain {
    private BigInteger calculateResult = new BigInteger("0");
    private String inputContent;

    public void StartCalculator() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        inputContent = Console.readLine();
    }

    public void getCalculateResult() {
        System.out.println("결과 : " + calculateResult);
    }
}
