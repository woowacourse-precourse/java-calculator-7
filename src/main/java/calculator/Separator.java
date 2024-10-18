package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separator {

    private List<String> separators;

    public Separator() {
        this.separators = new ArrayList<>(Arrays.asList(",", ":"));
    }

    public List<String> getSeparators() {
        return separators;
    }

    public String containCustomSeparator(String input) {
        if (input.startsWith("//") && input.contains("\\n")) {
            separators.add(input.substring(2, 3));
            this.separators = List.copyOf(separators);
            return input.substring(5);
        }
        return input;
    }

    public String getRegex() {
        return String.join("|", separators);
    }


}
