package calculator.input;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DefaultInput {
    public int defaultParseSum(String input){
        StringTokenizer tokenizer = new StringTokenizer(input, ",:");
        ArrayList<Integer> tokens = new ArrayList<>();  // 구분된 토큰을 저장할 리스트

        while(tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();

            // 구분자를 통해 분리한 토큰이 숫자가 아닌 경우 예외 처리
            if (!token.matches("\\d+")) {
                throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다");
            }

            // 숫자로 변환
            int tokenToInt = Integer.parseInt(token);

            // 숫자가 양수가 아닌 경우 예외 처리
            if (tokenToInt <= 0) {
                throw new IllegalArgumentException("양수가 아닌 값이 포함되어 있습니다");
            }

            // 양수일 경우 리스트에 추가
            tokens.add(tokenToInt);
        }
        // 합을 저장할 변수
        int result = 0;
        for(int num:tokens){
            result += num;
        }
        return result;
    }
}
