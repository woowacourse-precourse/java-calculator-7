package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Factor factor = new Factor();
        Calculator calculator = new Calculator(factor);

        if (args.length == 0) {
            return;
        }

        String input = args[0];

        try {
            int result = calculator.calculate(input);
            System.out.println("계산 결과: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}