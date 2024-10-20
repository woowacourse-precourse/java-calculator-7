package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    private static final String DEFAULT_SEPARATOR = ",|:";
    static String activeSeparator;
    String customSeparator;


    public static String checkCustomSeparator(String input) {
        if (input.startsWith("//")) {
            System.out.println("커스텀 있음");
            return handleCustomSeparator(input);
        }
        System.out.println("커스텀 없음");
        return DEFAULT_SEPARATOR;
    }

    private static String handleCustomSeparator(String input) {
        Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
        if (matcher.find()) {
            String customSeparator = Pattern.quote(matcher.group(1));
            System.out.println("커스텀 구분자 : " + customSeparator );
            activeSeparator = DEFAULT_SEPARATOR + "|" + customSeparator;
            System.out.println(activeSeparator);
            cleanInput(input);
            return activeSeparator;
        }
        System.out.println("커스텀 구분자 없음");
        return input;
    }

    public static String cleanInput(String input) {
        System.out.println("음>?" +input);
        input = input.split("\\\\n", 2)[1];
        System.out.println("커스텀 구분자가 있고, 숫자만 분리해놓음" + input);
        return input;
    }

}
