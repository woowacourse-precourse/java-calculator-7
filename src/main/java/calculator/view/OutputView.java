package calculator.view;

public class OutputView {

    private static final String RESULT = "결과 : ";

    public void result(Number result){
        System.out.println(RESULT + result);
    }
}
