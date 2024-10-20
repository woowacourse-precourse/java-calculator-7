package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogicHandler {


    public LogicHandler() {
    }

    public List<String> splitInputString(String customSplitter, String inputString) {
        StringBuilder sb = new StringBuilder();
        sb.append(customSplitter);
        sb.append("|,|:");

        return new ArrayList<>(Arrays.asList(inputString.split(sb.toString())));
    }

    public void removeEmpty(List<String> inputString) {
        inputString.removeIf(str -> str == null || str.isEmpty());
    }

    public void checkInputString(List<String> inputString) {
        for (String i : inputString) {
            if (!i.matches("\\d+")) {
                throw new IllegalArgumentException();
            }
            if (Integer.parseInt(i) <= 0) {
                throw new IllegalArgumentException();
            }
        }
    }

}
