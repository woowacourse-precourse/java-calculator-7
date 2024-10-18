package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = new Calculator();

        try {
            calculator.run();
        } catch (IllegalArgumentException e) {
            System.out.println("오류 발생 : " + e.getMessage());
        }

    }
}
