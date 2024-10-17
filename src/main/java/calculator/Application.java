package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();

        String userInput = inputHandler.getInput();
        System.out.println(userInput);
    }
}
