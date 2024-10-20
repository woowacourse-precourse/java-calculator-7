package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputHandler {

    private String customSplitter;
    private String inputString;
    final private String CUSTOM_START = "//";
    final private String CUSTOM_END = "\\n";

    public InputHandler() {
        input();
    }

    public void input() {
        String tempInput = Console.readLine();

        if (tempInput.startsWith(CUSTOM_START) && tempInput.contains(CUSTOM_END)) {
            customSplitter = tempInput.substring(
                tempInput.indexOf(CUSTOM_START) + CUSTOM_START.length(),
                tempInput.indexOf(CUSTOM_END));
            inputString = tempInput.substring(tempInput.indexOf(CUSTOM_END) + CUSTOM_END.length());
            System.out.println("case1");
            return;
        }

        if (tempInput.startsWith(CUSTOM_START)) {
            customSplitter = tempInput.substring(
                tempInput.indexOf(CUSTOM_START) + CUSTOM_START.length());
            tempInput = Console.readLine();
            System.out.println("case2");
        }

        if (tempInput == null) {
            throw new IllegalArgumentException();
        }
        inputString = tempInput;
    }

    public String getCustomSplitter() {
        return customSplitter;
    }

    public String getInputString() {
        return inputString;
    }


}
