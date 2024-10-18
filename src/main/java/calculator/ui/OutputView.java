package calculator.ui;

import static calculator.global.constant.Message.*;


public class OutputView {

    public void printReadLettersMessage() {
        println(READ_LETTERS_MESSAGE);
    }

    public void printResult(int result) {
        println(RESULT_MESSAGE + Integer.toString(result));
    }

    private void println(String message) {
        System.out.println(message);
    }

}
