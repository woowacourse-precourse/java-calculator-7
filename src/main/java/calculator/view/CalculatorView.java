package calculator.view;

public class CalculatorView {
    //계산 결과 출력
    public static void displayResult(int result) {
        System.out.println("계산 결과: " + result);
    }

    //오류 메시지 출력
    public static void displayError(String message) {
        System.out.println("오류 발생: " + message);
    }
}

