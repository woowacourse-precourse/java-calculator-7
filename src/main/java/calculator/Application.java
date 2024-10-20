package calculator;


public class Application {
    public static void main(String[] args) {
                Input inputHandler = new Input();
                Calculator calculator = new Calculator();

                String input = inputHandler.getInput();

                int result = calculator.add(input);

                System.out.println("결과 : " + result);

    }
}
