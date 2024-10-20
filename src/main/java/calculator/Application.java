package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inStr = Console.readLine();

        Calculator calculator = new Calculator();
        calculator.setDefaultSeparator(new String[]{",", ":"});
        String customSeparator = calculator.getCustomSeparator(inStr);
        calculator.inspectInStr(inStr, customSeparator);
        System.out.println("결과 : " + calculator.calculateResult(inStr, customSeparator));
    }
}
