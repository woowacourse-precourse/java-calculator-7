package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    private static final String DEFAULT_SEPARATOR = ",|:";


    public static String checkCustomSeparator(String input) {
        if (input.startsWith("//")) {
            System.out.println("커스텀 있음");
            return input;
        }
        System.out.println("커스텀 없음");
        return DEFAULT_SEPARATOR;
    }

}
