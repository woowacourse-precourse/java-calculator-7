package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    
    private static final String DELIMITER = "[,:]";
    
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        
        String input = Console.readLine();
        if (input.isEmpty()) {
            return;
        }
        
        int result = calculateSum(input);
        System.out.println("결과 : " + result);
    }
    
    private static int calculateSum(String input) {
        String[] numbers = input.split(DELIMITER);
        
        try {
            return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
    
}
