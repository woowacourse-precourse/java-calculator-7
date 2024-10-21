package calculator.view;

import calculator.model.CalculatorModel;
import camp.nextstep.edu.missionutils.Console;

public class AdditionCalculatorView implements CalculatorView {

    private static final String INPUT_STRING = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_STRING = "결과 : ";

    @Override
    public void input(CalculatorModel model) {
        System.out.println(INPUT_STRING);
        try {
            String input = Console.readLine();
            model.setInput(input);
        } finally {
            Console.close();
        }
    }

    @Override
    public void output(CalculatorModel model) {
        System.out.println(OUTPUT_STRING + model.getResult());
    }
}
