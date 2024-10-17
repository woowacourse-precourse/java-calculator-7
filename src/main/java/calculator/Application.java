package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = new Calculator();

        try {
//            System.out.println("결과 : " + calculator.add(""));
            System.out.println("결과 : " + calculator.add("//;\\n"));
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
