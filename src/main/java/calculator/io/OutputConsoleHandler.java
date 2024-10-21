package calculator.io;

public class OutputConsoleHandler {

    public static final String OUTPUT_MESSAGE = "결과 : ";

    public void showCalculatedResult(double result) {
        if (isInteger(result)) {
            System.out.println(OUTPUT_MESSAGE + (int) result);
            return;
        }

        System.out.println(OUTPUT_MESSAGE + result);
    }

    private boolean isInteger(double result) {
        return result == Math.floor(result);
    }

    public void showContinueMessage() {
        System.out.println("애플리케이션을 계속하려면 1을 입력하세요");
        System.out.println("애플리케이션을 종료하려면 2을 입력하세요");
    }

    public void showAppExitMessage() {
        System.out.println("애플리케이션을 종료합니다.");
    }
}
