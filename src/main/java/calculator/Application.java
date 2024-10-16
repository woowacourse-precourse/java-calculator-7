package calculator;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

public class Application {

    public static void main(String[] args) {
        String separator = "([,:])";
        String input = Console.readLine();

        if (isCustomSeparator(input)) {
            separator = findCustomSeparator(input);
            input = findOriginalText(input);
        }

        System.out.println("결과 : " + execute(input, separator));
    }

    private static String execute(String input, String separator) {
        int sum = 0;
        if (StringUtils.isBlank(input)) {
            return String.valueOf(sum);
        }

        try {
            sum = sum(input.split(separator));
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return String.valueOf(sum);
    }

    private static int sum(String[] strings) throws Exception {
        int sum = 0;
        for (String str : strings) {
            sum += Integer.parseUnsignedInt(str);
        }

        return sum;
    }

    private static String findCustomSeparator(String input) {
        int separatorIndex = input.indexOf("\\n");

        return input.substring(2, separatorIndex);
    }

    private static boolean isCustomSeparator(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }

    private static String findOriginalText(String input) {
        int originalTextIndex = input.indexOf("\\n") + 2;

        return input.substring(originalTextIndex);
    }
}
