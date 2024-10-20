package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    public static final String DEFAULT_SEPARATOR = ",|:";
    public static String activeSeparator;



    public static String checkCustomSeparator(String input) {
        if (input.startsWith("//")) {
        System.out.println("커스텀 있음");
        handleCustomSeparator(input);
        return cleanInput(input);
    }

        return input;
    }


    private static void handleCustomSeparator(String input) {
        Matcher matcher = Pattern.compile("//(.)\\\\n").matcher(input);
        if (matcher.find()) {
            String customSeparator = Pattern.quote(matcher.group(1));
            System.out.println("커스텀 구분자 : " + customSeparator);
            activeSeparator = DEFAULT_SEPARATOR + "|" + customSeparator;
            System.out.println("활성 구분자: " + activeSeparator);
        }
    }

    public static String cleanInput(String input) {
        System.out.println("현재 input 상태 : " + input);
        String[] parts = input.split("\\\\n", 2);

        return parts[1];


    }


}
