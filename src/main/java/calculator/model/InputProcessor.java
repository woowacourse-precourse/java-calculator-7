package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class InputProcessor {

    private String input;
    private List<String> delimiterList = new ArrayList<>();

    private static final String CUSTOM_DELIM_START = "//";
    private static final String CUSTOM_DELIM_END = "\n";

    public InputProcessor(String input) {
        this.input = input;
        delimiterList.add(",");
        delimiterList.add(":");
    }

    public boolean isDefaultCase() {
        return Character.isDigit(input.charAt(0));
    }

    public boolean isCustomCase() {
        return input.startsWith(CUSTOM_DELIM_START);
    }

    public void getCustomDelimiter() {
        while (input.indexOf(CUSTOM_DELIM_START) == 0) {
            String customDelimiter = input.substring((input.indexOf(CUSTOM_DELIM_START) + CUSTOM_DELIM_START.length()),
                    (input.indexOf(CUSTOM_DELIM_END) - CUSTOM_DELIM_END.length() + 1));
            delimiterList.add(customDelimiter);

            input = input.substring(input.indexOf(CUSTOM_DELIM_END) + CUSTOM_DELIM_END.length());
        }
    }

}
