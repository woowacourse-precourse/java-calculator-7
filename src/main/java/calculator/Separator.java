package calculator;

import java.util.ArrayList;
import java.util.List;

public class Separator {

    private ArrayList<String> separators = new ArrayList<>(List.of(",", ":"));

    public String addCustomParser(String input) {
        String processedString = "";
        if (input.startsWith("//")) {
            int limitIndex = input.indexOf("\\n");
            if (limitIndex != -1) {
                String customSeperator = input.substring(2, limitIndex);
                separators.add(customSeperator);
                processedString = input.substring(limitIndex + 2);
                return processedString;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return input;
    }
    public String createDelimiterRegex() {
        return String.join("|", separators);
    }
}
