package calculator.parser;

import static calculator.validation.Validator.*;

public class StringParser {

    String getSeparator(String input) {
        String separator = ",|:";

        if(input.startsWith("//")){
            int index = input.indexOf("\\n");
            separator += "|" + input.substring(2, index);
        }

        return separator;
    }

    public String[] parseInput(String input) {
        String[] strings = input.split(getSeparator(input));

        if(strings[0].equals("//")){
            int index = strings[1].indexOf("\\n");
            strings[1] = input.substring(index + 1);
        }

        validateChar(strings);
        return strings;
    }


}
