package calculator;

import calculator.util.StringSplitter;
import calculator.util.StringValidator;

public class Application {
    private final InputHandler inputhandler;
    private final ArrayCalculator arraycalculator;
    private static final StringValidator validator = new StringValidator();
    private static final StringSplitter splitter = new StringSplitter(validator);

    public Application(InputHandler inputhandler, ArraySumCalculator arraysumcalculator) {
        this.inputhandler = inputhandler;
        this.arraycalculator = arraysumcalculator;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application(new InputHandler(), new ArraySumCalculator(splitter));
        application.run(application);
    }

    public void run(Application application) {
        String input = inputhandler.userInput();
        int result = arraycalculator.sumArrayElements(input);
        System.out.println("결과 : " + result);
    }
}