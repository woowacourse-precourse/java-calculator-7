package calculator;

public class Application {
    public static void main(String[] args) {
        // 입력 규칙 안내
        InputRulePrinter rulePrinter = new InputRulePrinter();
        rulePrinter.printInputRules();

        // 입력 문자열 받기
        InputHandler inputHandler = new InputHandler();
        String userInput = inputHandler.getUserInput();

        // 입력 처리 및 계산 로직 추가 필요
    }
}
