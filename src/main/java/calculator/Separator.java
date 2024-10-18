package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separator {

    private List<String> separators;

    public Separator() {
        this.separators = new ArrayList<>(Arrays.asList(EnumClass.COMMA.getSymbol(), EnumClass.COLON.getSymbol()));
    }

    public List<String> getSeparators() {
        return separators;
    }

    public String containCustomSeparator(String input) {
        if (input.startsWith(EnumClass.DESIGNATED_SEPARATOR_START.getSymbol()) && input.contains(
                EnumClass.DESIGNATED_SEPARATOR_END.getSymbol())) {
            int customSeparatorStartIdx = EnumClass.DESIGNATED_SEPARATOR_START.getSymbolLength();
            int customSeparatorEndIdx = input.indexOf(EnumClass.DESIGNATED_SEPARATOR_END.getSymbol());

            separators.add(input.substring(customSeparatorStartIdx, customSeparatorEndIdx));
            this.separators = List.copyOf(separators);
            return input.substring(customSeparatorEndIdx + EnumClass.DESIGNATED_SEPARATOR_END.getSymbolLength());
        }
        return input;
    }

    public String getRegex() {
        return String.join("|", separators);
    }


}
