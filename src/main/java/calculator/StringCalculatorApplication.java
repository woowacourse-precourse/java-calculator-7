package calculator;

public class StringCalculatorApplication implements CalculatorApplication {

    private final ApplicationView applicationView;
    private final Calculator caclulator;

    public StringCalculatorApplication(ApplicationView applicationView, Calculator caclulator) {
        this.applicationView = applicationView;
        this.caclulator = caclulator;
    }

    @Override
    public void run() {
        try {
            String value = applicationView.requestValue();
            String result = caclulator.calculate(value);
            applicationView.printResult(result);
        } catch (IllegalArgumentException e) {
            applicationView.printError(e.getMessage());
        }
    }
}
