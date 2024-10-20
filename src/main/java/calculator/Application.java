package calculator;

public class Application {
    public static void main(String[] args) {
        // MVC의 각 요소를 생성
        CalculatorModel model = new CalculatorModel();
        ConsoleView view = new ConsoleView();
        DelimiterFactory delimiterFactory = new DelimiterFactory();
        CalculatorController controller = new CalculatorController(model, view, delimiterFactory);

        // 애플리케이션 실행
        controller.run();
    }
}
