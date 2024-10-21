package calculator;

public class Out {
    private Out() {
        // 유틸리티 클래스의 인스턴스화 방지
    }
    public static void printMessage(String message) {
        System.out.println(message);
    }
    public static void printResult(int result) {
        printMessage("결과 : " + result);
    }
}
