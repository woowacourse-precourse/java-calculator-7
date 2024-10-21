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
    public static int add(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        String symbol = ",|:"; 

        
        Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(str);
        if (matcher.find()) {
        	symbol = Pattern.quote(matcher.group(1));  
            str = matcher.group(2); 
        }

        String[] num = str.split(symbol);
        return calculate(num);
    }
    
    
    private static int calculate(String[] num) {
        int sum = 0;
        for (String n : num) {
            if (!n.isEmpty()) {
                int intNum = exceptionHandle(n);
                sum += intNum;
            }
        }
        return sum;
    }



   
}
