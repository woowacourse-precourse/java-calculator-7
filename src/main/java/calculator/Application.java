package calculator;

public class Application {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);
        controller.run(); // 예외가 발생하면 프로그램이 종료됨
    }
}
