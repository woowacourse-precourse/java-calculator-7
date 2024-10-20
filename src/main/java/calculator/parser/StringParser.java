package calculator.parser;

import java.util.regex.Pattern;

import static calculator.validation.Validator.*;

public class StringParser {

    String getSeparator(String input) {
        String separator = ",|:";

        if(input.startsWith("//")){
            int index = input.indexOf("\\n");
            String customSeparator = input.substring(2, index);

            separator += "|" + Pattern.quote(customSeparator);
        }

        return separator;
    }

    public String[] parseInput(String input) {
        String[] strings = input.split(getSeparator(input));

        if(strings.length != 0){
            if(strings[0].equals("//")){
                int index = strings[1].indexOf("\\n");
                strings[1] = strings[1].substring(index + 2);
            }
        }

        validateChar(strings);
        return strings;
    }

}
