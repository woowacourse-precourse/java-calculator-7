package calculator;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        Calculator calculator = new Calculator();
        int sum = calculator.calculate();
        System.out.println("결과 : " + sum);
    }
}
