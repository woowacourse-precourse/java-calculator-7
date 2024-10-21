package calculator;

import java.util.List;

public final class NumberString {
    private NumberString(){

    }

    public static Character getCustomDivider(String Input) {
        if(Input.startsWith("//") && Input.startsWith("\\n", 3)){
            return Input.charAt(2);
        }
        return null;
    }

    public static List<String> parse(String input){
        Character customDivider = getCustomDivider(input);
        if(customDivider != null) {
            input = input.substring(5);
        }

        Separator separator = new Separator(customDivider);
        return separator.separate(input);
    }
}
