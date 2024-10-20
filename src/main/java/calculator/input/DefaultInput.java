package calculator.input;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DefaultInput {
    public int defaultParseSum(String input){
        StringTokenizer tokenizer = new StringTokenizer(input, ",:");
        ArrayList<Integer> tokens = new ArrayList<>();  // 구분된 토큰을 저장할 리스트

        while(tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();

            // 숫자로 변환
            int tokenToInt = Integer.parseInt(token);

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
