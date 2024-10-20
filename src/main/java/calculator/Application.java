package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String DELIMITER = "[,:]";
    
    public static void main(String[] args) {
        int result = 0;
        
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        
        String input = Console.readLine();
        if (input.isEmpty()) {
            return;
        }
        
        if (input.contains(COMMA) && input.contains(COLON)) {
            String[] numbers = input.split(DELIMITER);
            
            try {
                result = Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .sum();
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
        } else if (input.contains(COMMA)) {
            String[] numbers = input.split(COMMA);
            
            try {
                result = Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .sum();
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
        } else if (input.contains(COLON)) {
            String[] numbers = input.split(COLON);
            
            try {
                result = Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .sum();
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
        }
        
        
        System.out.println("결과 : " + result);
    }
    
}
