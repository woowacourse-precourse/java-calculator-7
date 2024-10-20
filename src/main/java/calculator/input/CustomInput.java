package calculator.input;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class CustomInput {
    // 커스텀 구분자로 파싱
    public int customParseSum(String delimiter, String input_nums){
        // 커스텀 구분자로 구분
        StringTokenizer tokenizer = new StringTokenizer(input_nums, delimiter);
        ArrayList<Integer> nums = new ArrayList<>(); // 구분된 토큰 저장할 리스트

        while(tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            // 토큰이 숫자인지 확인
            if (!token.matches("\\d+")) {  // 숫자가 아닐 경우 예외 발생
                throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다");
            }

            // 숫자로 변환
            int tokenToInt = Integer.parseInt(token);

            // 숫자가 양수가 아닌 경우 예외 발생
            if (tokenToInt <= 0) {
                throw new IllegalArgumentException("양수가 아닌 값이 포함되어 있습니다");
            }

            // 양수일 경우 리스트에 추가
            nums.add(tokenToInt);
        }
        int result = 0;
        for(int num : nums) {
            result += num;
        }

        return result;
    }
}
