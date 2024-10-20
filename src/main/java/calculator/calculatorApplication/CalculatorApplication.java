package calculator.calculatorApplication;

public class CalculatorApplication {
    private final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private final String RESULT_MESSAGE = "결과 : ";
    private final InputReader inputReader;
    private final OutputPrinter outputPrinter;
    private final Calculator calculator;

    public CalculatorApplication(InputReader inputReader, OutputPrinter outputPrinter, Calculator calculator) {
        this.inputReader = inputReader;
        this.outputPrinter = outputPrinter;
        this.calculator = calculator;
    }

    public void run() {
        outputPrinter.println(START_MESSAGE);
        String readLine = inputReader.readLine();
        int result = calculator.calculate(readLine);
        outputPrinter.println(RESULT_MESSAGE + result);
    }
}
