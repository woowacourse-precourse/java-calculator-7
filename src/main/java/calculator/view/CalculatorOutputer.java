package calculator.view;

import java.text.DecimalFormat;

public class CalculatorOutputer {

    public void printIntro() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
    }

    public void printResult(float result) {
        DecimalFormat df = new DecimalFormat("#.####");
        System.out.println("결과 : " + df.format(result));
    }
}
