package calculator;

public class Application {
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        String inputString = view.readString();
        CalculatorController controller = new CalculatorController(inputString);
    }
}
