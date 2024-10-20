package calculator;

public class Application {
    public static void main(String[] args) {
        InputHandler.welcome();
        String input = InputHandler.getInput();
        String result = InputValidator.validate(input);
        System.out.println("결과 : "+result);
    }
}
