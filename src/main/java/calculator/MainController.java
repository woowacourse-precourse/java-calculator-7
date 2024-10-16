package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {

    public static void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        // 1. 기본 구분자로 분리
        List<String> colonOrCommaSplited = Arrays.asList(inputString.split(",|:"));
        //1-1. 출력해서 확인
        for (String part : colonOrCommaSplited) {
            System.out.println(part);
        }

    }
}
