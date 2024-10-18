package calculator.ui;

import static calculator.global.constant.Message.*;

import calculator.global.constant.Message;
import java.util.function.ObjIntConsumer;

public class OutputView {

    public void printReadLettersMessage() {
        println(READ_LETTERS_MESSAGE);
    }

    private void println(String message) {
        System.out.println(message);
    }

}
