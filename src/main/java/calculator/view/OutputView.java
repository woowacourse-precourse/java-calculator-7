package calculator.view;

import static calculator.constant.Constant.RESULT_MESSAGE;

public class OutputView {

    public void showResult(Long result){
        System.out.println(RESULT_MESSAGE + result);
    }
}
