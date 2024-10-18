package calculator;

import java.util.Arrays;

public class StringCalculator {
    private static boolean isExistCustomDelim(String data){
        return data.matches(Delimiter.CUSTOM.getRegex());
    }

    private static String getCustomDelim(String data){
        return data.replaceAll(Delimiter.CUSTOM_DELIM.getRegex(), "");
    }
}