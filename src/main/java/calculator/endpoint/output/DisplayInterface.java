package calculator.endpoint.output;

public class DisplayInterface {
    public static void displaySystemMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public static void displayAnswer(int answer) {
        System.out.println("결과 : " + answer);
    }
}
