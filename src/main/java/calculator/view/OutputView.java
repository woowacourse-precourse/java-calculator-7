package calculator.view;

import static calculator.util.Constants.PROGRAM_END;
import static calculator.util.Constants.PROGRAM_START;

public class OutputView {

    public void printStartMessage() {
        System.out.println(PROGRAM_START.getMessage());
    }

    public void printResult(int result) {
        System.out.println(PROGRAM_END.getMessage() + result);
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
