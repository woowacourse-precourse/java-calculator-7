package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {

    public static void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        //2. 커스텀 구분자로 분리
        String prefix = inputString.substring(0, 2);
        String suffix = inputString.substring(3, 5);
        //2. 커스텀 구분자로 분리
        if (prefix.equals("//") && suffix.equals("\\n")) {
            String customDelimiter = String.valueOf(inputString.charAt(2));
            String newInputString = inputString.substring(5);
            String[] customDelimiterSplitted = newInputString.split(customDelimiter);
            //2-2. 출력해서 분리됐는지 확인
            for (String part : customDelimiterSplitted) {
                System.out.println(part);
        }
        }

//        // 1. 기본 구분자로 분리
//        List<String> defaultDelimterSplitted = Arrays.asList(inputString.split(",|:"));
//        //1-1. 출력해서 확인
//        for (String part : defaultDelimterSplitted) {
//            System.out.println(part);
//        }

    }
}
