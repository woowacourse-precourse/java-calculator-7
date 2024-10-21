package calculator.view;

public class OutputView {
    // 결과 출력 메서드
    public static void printResult(int result) {
        System.out.println("결과: " + result);
    }

    // 에러 메시지 출력 메서드
    public static void printErrorMessage(String message) {
        System.out.println("에러: " + message);
    }
}
