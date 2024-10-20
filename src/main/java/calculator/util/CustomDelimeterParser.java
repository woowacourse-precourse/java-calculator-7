package calculator.util;

import static calculator.constant.ExceptionMessage.*;

public class CustomDelimeterParser {
    public static String[] parse(String inputStr, String delimiter) {
        if(inputStr.startsWith("//")){
            String[] split_str = inputStr.split("\\\\n");
            if(split_str.length == 2){
                String customDelimiter = split_str[0].substring(2);
                delimiter += "|" + customDelimiter;
                inputStr = split_str[1];
            } else {
                throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER_FORMAT);
            }
        }
        return new String[]{inputStr, delimiter};
    }
}
