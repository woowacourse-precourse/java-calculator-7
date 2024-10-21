package calculator;

public class OutputHandler {
    public static void printInputRequest() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public static void printResult(int value) {
        System.out.println(String.format("결과 : %d", value));
    }
}
