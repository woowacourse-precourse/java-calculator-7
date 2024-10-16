package calculator.model;

import java.util.Arrays;
import java.util.List;

public class SeparatorParser {
    private final String SEPARATOR_FORMAT_STRING = "//|\\\\n";
    private final String BASIC_SEPERATOR = "\\,|\\:";

    public String[] separatorParse(String input) {
        List<String> inputSeparatorList = Arrays.stream(input.split(SEPARATOR_FORMAT_STRING))
                .map(String::trim)
                .filter(s -> (!s.isEmpty()))
                .toList();

        String separator = "";
        separator += BASIC_SEPERATOR;

        // validator 과정
        for (int inputSeparatorListIndex = 0; inputSeparatorListIndex < inputSeparatorList.size() - 1;
             inputSeparatorListIndex++) {
            String inputSeparator = inputSeparatorList.get(inputSeparatorListIndex);
            int inputSeparatorASCIIIndex = (int) inputSeparator.charAt(0);
            if ((inputSeparatorASCIIIndex >= 65 && inputSeparatorASCIIIndex <= 90) || (
                    inputSeparatorASCIIIndex >= 97 && inputSeparatorASCIIIndex <= 122)) {
                separator += ("|" + inputSeparator);
            } else if ((inputSeparatorASCIIIndex >= 33 && inputSeparatorASCIIIndex <= 47)
                    || inputSeparatorASCIIIndex >= 58) {
                separator += ("|\\" + inputSeparator);
            }
        }
        String[] separatedString = new String[2];
        separatedString[0] = separator;
        separatedString[1] = inputSeparatorList.getLast();
        return separatedString;
    }
}
