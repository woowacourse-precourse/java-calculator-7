package calculator;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        StringParser stringParser = new StringParser();
        Calculator calculator = new Calculator();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = inputHandler.getInput();
        int[] numbers = stringParser.parse(input);
        int sumResult = calculator.add(numbers);
        String output = outputHandler.getOutPut(sumResult);
        System.out.println(output);
    }
}
