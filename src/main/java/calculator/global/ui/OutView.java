package calculator.global.ui;

public class OutView {

    public void startMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void resultMessage(int result) {
        System.out.println("결과 : " + result);
    }
}
