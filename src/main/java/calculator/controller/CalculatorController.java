package calculator.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;

public class CalculatorController {

    public static void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = readLine();

        if (str.isEmpty()) {
            print(0);
            return;
        }

        if (isCustomDelimiter(str)) {
            print(customDelimiter(str));
        } else {
            print(defaultDelimiter(str));
        }
    }

    private static boolean isCustomDelimiter(String str) {
        String firstStr = "";
        String secondStr = "";
        if (str.length() >= 5) {
            firstStr = str.substring(0, 2);
            secondStr = str.substring(3, 5);
        }

        return firstStr.equals("//") && secondStr.equals("\\n");
    }

    private static Integer defaultDelimiter(String str) {
        List<String> defaultValues = Arrays.asList(str.split(":|,"));
        validation(defaultValues);
        return calculateSum(defaultValues);
    }

    private static Integer customDelimiter(String str) {
        String delimiter = String.valueOf(str.charAt(2));
        String realNumStr = str.substring(5);

        List<String> customValues = Arrays.asList(realNumStr.split("\\Q" + delimiter + "\\E"));
        validation(customValues);
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

    private static void validation(List<String> values) {
        if (values.isEmpty()) {
            print(0);
            return;
        }
        if (values.size() == 1) {
            try {
                int intValue = Integer.parseInt(values.get(0));
                if (intValue < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("허용되지 않은 문자가 포함되어 있습니다.");
            }
        }
        for (String value : values) {
            try {
                int intValue = Integer.parseInt(value);
                if (intValue < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("문자가 포함되어 있습니다.");
            }

        }
    }
}