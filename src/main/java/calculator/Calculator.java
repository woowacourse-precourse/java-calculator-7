package calculator;

public class Calculator {

    public static int add(String input) {

        // 빈 입력에 대한 처리
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delim = ",|:";
        String numbers = input;

        // 구분자로 숫자 분리 및 덧셈
        String[] tokens = numbers.split(delim);
        int sum = 0;
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            sum += number;
        }
        
        return sum;
    }

}
