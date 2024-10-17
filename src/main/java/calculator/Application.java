package calculator;

public class Application {
    public static void main(String[] args) {
        // 1. 입력받기
        InputHandler inputHandler = new InputHandler();
        String str = inputHandler.getInput();

        if (str.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        // 2. Calculator 실행
        Calculation calculation = new Calculation(str);
        int result = calculation.calculate();
        System.out.println("결과 : " + result);
    }
}
