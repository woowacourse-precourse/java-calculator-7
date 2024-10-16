package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {

    public static void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();
        int sum=0;

        SplitbyCustomDelimiter(inputString);

        SplitbyDefaultDelimiter(inputString);
    }

    private static List<String> SplitbyDefaultDelimiter(String inputString) {
        List<String> defaultDelimterSplitted = Arrays.asList(inputString.split(",|:"));
        return defaultDelimterSplitted;
    }

    private static List<String> SplitbyCustomDelimiter(String inputString) {
        String prefix = inputString.substring(0, 2);
        String suffix = inputString.substring(3, 5);
        List<String> customDelimiterSplitted = null;

        if (prefix.equals("//") && suffix.equals("\\n")) {
            String customDelimiter = String.valueOf(inputString.charAt(2));
            String remainingInput = inputString.substring(5);
            customDelimiterSplitted = Arrays.asList(remainingInput.split(customDelimiter));
        }
        return customDelimiterSplitted;
    }
//            for (String part : customDelimiterSplitted) {
//                sum += Integer.parseInt(part);
//            }
}
