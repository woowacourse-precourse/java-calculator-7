package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = Console.readLine();

        int result = 0;
        // 문자열이 아무것도 입력이 안되었다면 0으로 설정

        // 문자열 입력시 , : 로 구분하기
        String[] split = inputStr.split(":|,");
        for (String s : split) {
            int s1 = Integer.parseInt(s);
            result +=s1;
        }
        System.out.println("결과 : "+ result);





    }

}
