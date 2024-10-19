package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private String inputString;
    private String removedString = "";
    private final List<String> separator = new ArrayList<>();

    /**
     * 사용자 입력
     */


    public void run() {
        getUserInput();
        parseCustomSeparator();
        addBasicSeparator();
        parseOperand();
        printResult();
    }
}
