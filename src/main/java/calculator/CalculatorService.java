package calculator;

public class CalculatorService {
    private final OutputHandler outputHandler;
    private final InputHandler inputHandler;


    // 생성자에서 의존성 주입
    public CalculatorService() {
        this.outputHandler = new OutputHandler();
        this.inputHandler = new InputHandler();
    }


    public void run() {
        try {
            outputHandler.guideComment();
            String userInput = inputHandler.getUserInput();
            Calculator calculator = new Calculator(userInput);
            int result = calculator.calculate();  // 계산 수행
            outputHandler.printSum(result); // 결과 출력
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
