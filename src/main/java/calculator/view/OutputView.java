package calculator.view;

public class OutputView {
    public void inform() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void result(Long sum) {
        System.out.println("결과 : " + sum);
    }
}
