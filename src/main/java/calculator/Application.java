package calculator;
import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = input.split("[,:]");

        if (input.startsWith("//")) {
            String delimiter = input.substring(2, input.indexOf("\n"));
            input = input.substring(input.indexOf("\n") + 1);
            numbers = input.split(delimiter);
        }
    
        int sum = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number.trim()); 
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            sum += num; 
        }  
        System.out.println("결과 : " + sum);
    }
}
