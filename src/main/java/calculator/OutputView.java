package calculator;

public class OutputView {
    public void printResult(int result) {
        System.out.printf(InfoMessage.RESULT.getMsg(), result);
    }
}
