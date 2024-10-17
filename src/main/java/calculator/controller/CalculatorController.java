package calculator.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;

public class CalculatorController {

    public static void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = readLine();

        print(defaultDelimiter(str));
    }

    private static Integer defaultDelimiter(String str) {
        List<String> defaultValues = Arrays.asList(str.split(":|,"));
        return calculateSum(defaultValues);
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
