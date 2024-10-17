package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeparatorManager {
    private List<String> separators = new ArrayList<>(Arrays.asList(",", ":"));

    public List<String> getSeparators() {
        return separators;
    }

    public void addCustomSeparator(String input) {
        if (input.startsWith("//")){
            int separatorIndex = input.indexOf("\n");
            separators.add(input.substring(2, separatorIndex));
        }
    }
}
