package calculator.controller;

import calculator.model.Arithmetic;
import calculator.model.Delimiter;
import calculator.model.InputData;
import calculator.model.SumCalculator;
import calculator.util.Message;
import calculator.view.InputView;
import calculator.view.OutputView;

public class StringCalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final DelimiterController delimiterController;
    private final SumCalculator sumCalculator;

    public StringCalculatorController(Builder builder) {
        this.inputView = builder.inputView;
        this.outputView = builder.outputView;
        this.delimiterController = builder.delimiterController;
        this.sumCalculator = builder.sumCalculator;
    }

    public InputData handoverInput(){
        String input = inputView.inputData();
        return new InputData(input);
    }

    public void runApplication(){
        outputView.printMessage(Message.INTRO.getSentence());

        InputData inputData = handoverInput();
        Delimiter delimiter = delimiterController.createDelimiterPart(inputData);

        Arithmetic arithmetic = new Arithmetic(delimiter, inputData);

        outputView.printMessage(Message.RESULT.getSentence() + sumCalculator.calculate(arithmetic));
    }

    public static class Builder {
        private InputView inputView;
        private OutputView outputView;
        private DelimiterController delimiterController;
        private SumCalculator sumCalculator;

        public Builder withInputView(InputView inputView) {
            this.inputView = inputView;
            return this;
        }

        public Builder withOutputView(OutputView outputView) {
            this.outputView = outputView;
            return this;
        }

        public Builder withDelimiterController(DelimiterController delimiterController) {
            this.delimiterController = delimiterController;
            return this;
        }

        public Builder withSumCalculator(SumCalculator sumCalculator) {
            this.sumCalculator = sumCalculator;
            return this;
        }

        public StringCalculatorController build() {
            return new StringCalculatorController(this);
        }
    }

}
