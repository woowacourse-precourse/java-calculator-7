package calculator;

public class Application {
    private static Handler handler;

    public static void main(String[] args) {
        // 입력을 받는 기능
        String initialInput = Input.makeInput();
        // 입력을 처리하는 기능
        int[] numbers = handler.inputHandler(initialInput);
        // 덧셈을 진행하는 기능

        // 결과를 출력하는 기능


    }
}
