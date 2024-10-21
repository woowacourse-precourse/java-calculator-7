package calculator;
import camp.nextstep.edu.missionutils.*;
import java.util.List;
import java.util.regex.Pattern;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        List<String> numbers = parse(input);
    
        int sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                int num = Integer.parseInt(number.trim()); 
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }
                sum += num; 
            }  
        }
        System.out.println("결과 : " + sum);   
    }
    public static List<String> parse(String input) {
        if (input == null || input.trim().isEmpty()) {
            return List.of();
        }

        String delimiter = ",|:";
        String numbers = input;

        // 커스텀 구분자 
        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf("\n");

            if (delimiterEnd == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
            delimiter = Pattern.quote(input.substring(2, delimiterEnd));
            numbers = input.substring(delimiterEnd + 1); // \n은 1개의 문자 +1
        }
        return Arrays.asList(numbers.split(delimiter));
    }
}