package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static void run() {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine(); // 문자열 입력

        if(checkEmpty(str)){ // 입력 문자열 비어있는지 확인
            System.out.println("결과 : 0");
            return;
        }
    }

    // 입력한 문자열이 비었는지 확인 -> 비었으면 0 출력
    public static boolean checkEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
