package calculator;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("결과: " + calculator.addNumber("1,2:3,4"));
    }
}
