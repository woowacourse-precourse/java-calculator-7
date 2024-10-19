package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Cal calculator = new Cal();
        int result = calculator.cal();

        System.out.println("결과 : " + result);
    }
}
