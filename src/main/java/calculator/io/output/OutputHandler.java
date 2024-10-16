package calculator.io.output;

public class OutputHandler {

    private int sum;

    public OutputHandler(int sum) {
        this.sum = sum;
    }

    public void showUserInputMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void showAdditionResult() {
        System.out.println("결과 : " + sum);
    }

    public void updateCalculateResult(int sum) {
        this.sum = sum;
    }

}
