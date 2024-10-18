package calculator;

import calculator.plusCalculator.PlusCalculatorInterface;
import calculator.plusCalculator.PlusPlusCalculator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        PlusCalculatorInterface plusCalculator = new PlusPlusCalculator(Arrays.asList(",", ":"));
        String input;

        input = inputString();

        int result = plusCalculator.run(input);

        outputResult(result);
    }

    // 문자열 입력
    public static String inputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    // 결과 반환
    public static void outputResult(int result) {
        System.out.println("결과 : " + result);
    }
}
