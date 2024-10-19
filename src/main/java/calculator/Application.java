package calculator;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.inputStr();
        System.out.println("결과 : " + calculator.calculate());
    }
}
