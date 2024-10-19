package calculator.view;

/**
 * 콘솔에 출력하는 클래스.
 */
public class Out {
    private Out() {
    }

    /**
     * 메시지를 출력한다.
     */
    public static void printInputRequestMessage() {
        System.out.println("덧셈할 문자열을 입력해주세요");
    }

    public static void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
