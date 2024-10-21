package calculator.controller;

import calculator.model.Expression;
import calculator.model.Separator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.math.BigInteger;

public class Calculator {
    private InputView inputView;
    private OutputView outputView;
    private Separator separator;

    public Calculator(InputView inputView, OutputView outputView, Separator separator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.separator = separator;
    }

    public void start() {
        try {
            outputView.printlnMessage("덧셈할 문자열을 입력해 주세요.");
            String input = inputView.readInput();
            Expression expression = new Expression(input);
            separator.checkCustomSeparator(expression.getRawExpression());
            expression.processRawExpression(separator.getSeparatorList());
            BigInteger sum = expression.getListSum();
            outputView.printSum(sum);
        } catch (Exception exception) {
            outputView.printlnMessage("Exception is Occurred.\nDetail -> " + exception);
            throw new IllegalArgumentException();
        }
    }


}
