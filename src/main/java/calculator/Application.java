package calculator;

import calculator.controller.DelimiterController;
import calculator.controller.StringCalculatorController;
import calculator.model.Arithmetic;
import calculator.model.Delimiter;
import calculator.model.InputData;
import calculator.model.SumCalculator;
import calculator.util.Message;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        StringCalculatorController stringCalculatorController = new StringCalculatorController();
        DelimiterController delimiterController = new DelimiterController();
        SumCalculator sumCalculator = new SumCalculator();

        outputView.printMessage(Message.INTRO.getSentence());

        InputData inputData = stringCalculatorController.handoverInput();
        Delimiter delimiter = delimiterController.createDelimiterPart(inputData);

        Arithmetic arithmetic = new Arithmetic(delimiter, inputData);

        outputView.printMessage(Message.RESULT.getSentence() + sumCalculator.calculate(arithmetic));
    }
}
