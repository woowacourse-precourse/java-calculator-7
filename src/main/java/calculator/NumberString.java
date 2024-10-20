package calculator;

import java.util.List;

public final class NumberString {
    public static Character getSeparatorToken(String Input) {
        if(Input.startsWith("//") && Input.startsWith("\\n", 3)){
            return Input.charAt(2);
        }
        return null;
    }

    public static List<String> parse(String input){
        Character customSeparator = getSeparatorToken(input);
        if(customSeparator != null) {
            input = input.substring(5);
        }

        SeparatorManager separator = new SeparatorManager(customSeparator);
        return separator.getSeparatedStringNumber(input);
    }
}
