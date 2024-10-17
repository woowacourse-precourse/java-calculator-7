package calculator.domain;

import static calculator.constants.DelimiterConstants.*;

public class Parser {
    public static boolean hasCustomDelimiter(String string){
        if(string == null || string.length() < 5)
            return false;

        if(!string.startsWith(CUSTOM_DELIMITER_PREFIX))
            return false;

        int endIndex = 2;
        for(; endIndex < string.length()-1; endIndex++){
            if(string.startsWith(CUSTOM_DELIMITER_SUFFIX, endIndex))
               break;
        }

        if(endIndex == 2 || endIndex == string.length()-1)
            return false;

        return true;
    }

    public static String extractCustomDelimiter(String string){
        StringBuilder delimiter = new StringBuilder();

        for(int index = 2; index < string.length()-1; index++){
            if(string.startsWith(CUSTOM_DELIMITER_SUFFIX, index))
                break;

            delimiter.append(string.charAt(index));
        }

        return delimiter.toString();
    }
}
