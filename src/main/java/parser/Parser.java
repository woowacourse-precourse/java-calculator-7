package parser;

import separator.Separator;

public class Parser {

    public String parseStringToCalculate(String input) {

        Separator separator = new Separator();
        if (!separator.validateCustomSeparatorForParsing(input)) {
            throw new IllegalArgumentException();
        }

        if (input.substring(0, 4).equals("//\\n")) {
            return input.substring(4);
        }

        return input.substring(5);
    }

}
