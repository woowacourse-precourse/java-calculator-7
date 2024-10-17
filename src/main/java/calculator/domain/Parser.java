package calculator.domain;

import static calculator.constants.DelimiterConstants.*;

import java.util.ArrayList;
import java.util.List;

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

    public static List<Integer> parseNumbersFromInput(String string, List<String> delimiters) {
        List<Integer> result = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        int delimiterLength = delimiters.size() == 2 ? 1 : delimiters.getFirst().length();
        int index = delimiters.size() == 2 ? 0 : delimiterLength + 4;

        while (index < string.length()) {
            if (matchesDelimiter(string, index, delimiters)) {
                if(!number.isEmpty()){
                    result.add(Integer.parseInt(number.toString()));
                    number = new StringBuilder();
                }
                index += delimiterLength;
                continue;
            }
            number.append(string.charAt(index++));
        }

        if (!number.isEmpty())
            result.add(Integer.parseInt(number.toString()));
        return result;
    }

    private static boolean matchesDelimiter(String string, int start, List<String> delimiters){
        for(String delimiter : delimiters) {
            if(string.startsWith(delimiter,start))
                return true;
        }

        return false;
    }
}
