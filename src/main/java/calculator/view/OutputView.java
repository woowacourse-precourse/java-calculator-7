package calculator.view;

public class OutputView {
    private static final String RESULT_MESSAGE = "결과 : ";
    public static OutputView outputView;

    private OutputView(){
    }

    public static OutputView getInstance(){
        if(outputView == null){
            outputView = new OutputView();
        }
        return outputView;
    }

    public void printResult(int result){
        System.out.print(RESULT_MESSAGE + result);
    }

    public void closeOutputView() {
        if (outputView != null) {
            outputView = null;
        }
    }
}
