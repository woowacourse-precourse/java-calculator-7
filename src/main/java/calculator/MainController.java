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

        String prefix = inputString.substring(0, 2);
        String suffix = inputString.substring(3, 5);
        if (prefix.equals("//") && suffix.equals("\\n")) {
            String customDelimiter = String.valueOf(inputString.charAt(2));
            String newInputString = inputString.substring(5);
            String[] customDelimiterSplitted = newInputString.split(customDelimiter);

            for (String part : customDelimiterSplitted) {
                sum += Integer.parseInt(part);
            }
            System.out.printf("결과 : %d",sum);
        }

//        List<String> defaultDelimterSplitted = Arrays.asList(inputString.split(",|:"));
//        for (String part : defaultDelimterSplitted) {
//            sum += Integer.parseInt(part);
//        }
//        System.out.println(sum);
    }
}
