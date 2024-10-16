package calculator;


import java.util.Arrays;

public class Calculator {
    private Delimiter delimiter;

    public Calculator(Delimiter delimiter){
        this.delimiter = delimiter;
    }

    // 덧셈 계산 수행
    public int add(String input){
        // 입력이 null 이거나 빈 문자열이면 0을 반환
        if(input == null || input.isEmpty()){
            return 0;
        }

        String[] tokens = delimiter.split(input); // 입력 문자열을 나누어 배열로 변환

        int sum = 0;
        for(String token : tokens){
            // 빈 문자열이 아닌 경우에만 처리
            if(!token.isEmpty())
                sum += Integer.parseInt(token);
        }
        return sum;
    }
}
