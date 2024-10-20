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

}
