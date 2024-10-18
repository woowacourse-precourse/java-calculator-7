package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;

public class CalculatorView {

    public static String sumInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static void result(BigInteger result) {
        System.out.println("결과 : " + result);
    }
}
