package calculator.view;

public class OutputView {
    private final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private final String RESULT_MESSAGE = "결과 : ";

    public void printStartMessage(){
        System.out.println(START_MESSAGE);
    }
    public void resultIntegerMessage(Double addResult) {
        System.out.println(RESULT_MESSAGE + String.format("%.0f", addResult));
    }
    public void resultDoubleMessage(Double addResult) {
        System.out.println(RESULT_MESSAGE + addResult);
    }
}
