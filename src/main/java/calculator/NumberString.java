package calculator;

import java.util.List;

public final class NumberString {
    public static List<String> parse(String input){
        Character customSeparator = SeparatorManager.getCustomSeparator(input);
        if(customSeparator != null) {
            input = input.substring(5);
        }

        SeparatorManager separator = new SeparatorManager(customSeparator);
        return separator.getSeparatedStringNumber(input);
    }
}
