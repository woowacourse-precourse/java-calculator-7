package calculator;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            calculator.run();
        } catch (IllegalArgumentException e) {
            System.out.println("올바른 입력이 아닙니다.");
        } catch (ArithmeticException e) {
            System.out.println("연산 가능한 범위를 초과했습니다.");
        } catch (Exception e) {
            System.out.println("에러가 발생했습니다.");
        }
    }
}