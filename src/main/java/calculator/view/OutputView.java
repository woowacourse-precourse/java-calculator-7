package calculator.view;


public class OutputView {
    public static final String RESULT_MESSAGE = "결과 : ";

    public void showResult(Long result){
        System.out.println(RESULT_MESSAGE + result);
    }
}
