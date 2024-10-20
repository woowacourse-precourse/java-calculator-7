package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Calculator calculator = new Calculator();
        int result = calculator.calculate();
        System.out.println("결과 : " + result);
    }
}
