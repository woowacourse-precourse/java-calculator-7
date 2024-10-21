package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
    	runCalculator();
    }

    public static void runCalculator() {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String str = Console.readLine();

            int sum = add(str);
            System.out.println("결과 : " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println("에러: " + e.getMessage());
            throw e;  
        }
    }

   
}
