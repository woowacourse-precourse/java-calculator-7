package mvcpatterns.view;

public class AppView {
    private final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private final String END_MESSAGE = "결과 : ";

    public void printStartMessage() {
        System.out.println(this.START_MESSAGE);
    }

    public void printEndMessage(String result) {
        System.out.println(this.END_MESSAGE + result);
    }
}
