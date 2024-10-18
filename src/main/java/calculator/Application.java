package calculator;

import calculator.plusCalculator.PlusCalculatorInterface;
import calculator.plusCalculator.PlusPlusCalculator;
import calculator.view.Request;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        PlusCalculatorInterface plusCalculator = new PlusPlusCalculator(Arrays.asList(",", ":"));

        String input = Request.inputPlusCalculator();

        int result = plusCalculator.run(input);

        outputResult(result);
    }


    // 결과 반환
    public static void outputResult(int result) {
        System.out.println("결과 : " + result);
    }
}
