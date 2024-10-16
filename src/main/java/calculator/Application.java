package calculator;


public class Application {
    public static void main(String[] args) {
        String expression = InputHandler.getInput();
        Integer calculated = Calculator.calculate(expression);
        System.out.println(calculated);
    }
}
