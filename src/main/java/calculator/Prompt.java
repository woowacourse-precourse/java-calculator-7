package calculator;

public class Prompt {

    public void getCommand(Calculator calculator) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        InputHandler inputHandler = new InputHandler();
        int[] numbers = inputHandler.getInput();
        int result = calculator.calculate(numbers);

        System.out.println("결과 : " + result);
    }
}
