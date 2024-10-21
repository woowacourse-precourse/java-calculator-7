package calculator;
import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers;

        if (input.startsWith("//")) {
            int newLineIndex = input.indexOf("\n");
            if (newLineIndex == -1) {
                throw new IllegalArgumentException("구분자가 잘못되었습니다.");
            }
            String delimiter = input.substring(2, newLineIndex);
            input = input.substring(newLineIndex + 1);
            numbers = input.split("[" + delimiter + ",:]");
        }
        else {
            numbers = input.split("[,:]");
        }
    
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