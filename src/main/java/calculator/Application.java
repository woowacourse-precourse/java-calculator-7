package calculator;

public class Application {
    public static void main(String[] args) {

        String input = Input.getInput();
        Calculator calculator = new Calculator();
        int result = calculator.add(input);

        System.out.println("결과 : " + result);
    }
}
