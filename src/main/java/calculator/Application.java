package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = Console.readLine();

        int result = 0;

        if (inputStr.charAt(0)=='/' && inputStr.charAt(1)=='/'){
            String pivot = inputStr.substring(2, inputStr.indexOf('\\'));
            String target = inputStr.substring((inputStr.indexOf("n")+1));

            String[] split = target.split(pivot);

            for (String s : split) {
                int num = Integer.parseInt(s);
                result += num;
            }
        }

        else {
            String[] split = inputStr.split(":|,");
            for (String s : split) {
                int s1 = Integer.parseInt(s);
                result +=s1;
            }
        }

        System.out.println("결과 : "+ result);

    }

}
