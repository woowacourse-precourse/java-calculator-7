package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String UserInput = CalStart.InputMessage();
        int sum = InputValidate.calculateSum(UserInput);

        System.out.println("결과: " + sum);
    }
}
