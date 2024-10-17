package calculator.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;

public class CalculatorController {

    public static void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = readLine();

        if (isCustomDelimiter(str)) {
            print(customDelimiter(str));
        } else {
            print(defaultDelimiter(str));
        }
    }

    private static boolean isCustomDelimiter(String str) {
        String firstStr = str.substring(0, 2);
        String secondStr = str.substring(3, 5);

        if (firstStr.equals("//") && secondStr.equals("\\n")) {
            return true;
        }
        return false;
    }

    private static Integer defaultDelimiter(String str) {
        List<String> defaultValues = Arrays.asList(str.split(":|,"));
        return calculateSum(defaultValues);
    }

    private static Integer customDelimiter(String str) {
        String delimiter = String.valueOf(str.charAt(2));
        String realNumStr = str.substring(5);

        List<String> customValues = Arrays.asList(realNumStr.split("\\Q" + delimiter + "\\E"));

        return calculateSum(customValues);
    }

    private static int calculateSum(List<String> values) {
        int sum = 0;
        for (String value : values) {
            sum += Integer.parseInt(value);
        }
        return sum;
    }

    private static void print(Integer sum) {
        System.out.println(sum);
    }
}
