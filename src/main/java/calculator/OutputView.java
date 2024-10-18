package calculator;

public class OutputView {

    // 결과 출력
    public void printResult(int result) {
        System.out.println("결과: " + result);
    }

    // 에러 메시지 출력
    public void printError(String message) {
        System.out.println("에러 발생: " + message);
    }
}