package calculator;

public class CalculatorController {
    private CalculatorView view; // 컨트롤러에서 사용할 View 객체

    public CalculatorController(CalculatorView view) {
        this.view = view; // Application에서 전달받은 View를 저장
    }

    public void processInput() {
        // View를 사용해, 입력을 받는다
        String input = view.getInput();
        
        try {
            String[] numbers = DelimiterParser.parse(input);
            int result = Calculator.calculateSum(numbers);
            // View를 사용해, 결과를 출력
            view.displayResult(result);
        } catch (IllegalArgumentException e) {
            view.displayError(e.getMessage());
        }
    }
}