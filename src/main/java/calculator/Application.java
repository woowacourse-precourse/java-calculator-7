package calculator;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = inputHandler.getInput();
        String output = outputHandler.getOutPut(input);
        System.out.println(output);
    }
}
