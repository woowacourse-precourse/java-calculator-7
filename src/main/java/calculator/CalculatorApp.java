package calculator;

import calculator.operator.OperatorRepository;
import calculator.utils.Preprocessor;

public class CalculatorApp {

    private static final String DEFAULT_SEPARATORS = ":,";

    private InputView inputView;
    private Calculator calculator;
    private Preprocessor preprocessor;
    private OutputView outputView;

    public CalculatorApp() {
        this.inputView = new InputView();

        String userExpression = inputView.getUserInput();
        OperatorRepository operatorRepository = new OperatorRepository();

        this.preprocessor = new Preprocessor(userExpression, operatorRepository, DEFAULT_SEPARATORS);
        this.calculator = new Calculator(operatorRepository);
        this.outputView = new OutputView();
    }

    public void run() {
        String preprocessedExpression = preprocessor.preprocess();
        int answer = calculator.calculate(preprocessedExpression);
        outputView.displayResult(String.valueOf(answer));
    }
}
