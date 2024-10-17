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
            if(string.substring(endIndex,endIndex+2).equals(CUSTOM_DELIMITER_SUFFIX))
               break;
        }

        if(endIndex == 2 || endIndex == string.length()-1)
            return false;

        return true;
    }
}
