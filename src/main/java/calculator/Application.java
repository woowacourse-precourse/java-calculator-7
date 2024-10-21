package calculator;

public class Application {
    public static Handler handler = new Handler();

    public static void main(String[] args) {
        // 입력을 받는 기능
        String initialInput = Input.makeInput();
        // 입력을 처리하는 기능
        int[] numbers = handler.inputHandler(initialInput);
        // 덧셈을 진행하는 기능
        int result = handler.sumCalculator(numbers);
        // 결과를 출력하는 기능
        Output.printInteger("결과 : ", result);
    }
}
