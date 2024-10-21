package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    
    static int result = 0;
    
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        
        String input = Console.readLine();
        
        if (input.isEmpty()) {
            return;
        }
        
        String delimiter = "[.:]";
        
        if (input.startsWith("//")) {
            int customDelimiterIndex = input.indexOf("\\n");
            
            if (customDelimiterIndex != -1) {
                delimiter = input.substring(2, customDelimiterIndex);
                input = input.substring(customDelimiterIndex + 2);
            }
        }
        
        String[] numbers = input.split(delimiter);
        
        for (String number : numbers) {
            int parseNumber = Integer.parseInt(number);
            if (parseNumber < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            
            result += parseNumber;
        }
        
        System.out.println("결과 : " + result);
    }
    
}
