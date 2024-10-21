package calculator;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        String inputString = Display.displayInput();
        Display.displayInputResult(inputString);

        SumCalculator sumCalculator = new SumCalculator();
        int result = sumCalculator.sum(inputString);
        Display.displayOutputResult(result);
    }
}
