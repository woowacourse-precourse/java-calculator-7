package calculator.input;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DefaultInput {
    // 기본 구분자로 파싱
    public int defaultParseSum(String input){
        StringTokenizer st = new StringTokenizer(input, ",:");  // 쉼표와 콜론으로 구분자
        ArrayList<Integer> nums = new ArrayList<>(); // 구분된 토큰 저장할 리스트

        while(st.hasMoreTokens()){
            String token = st.nextToken();

            // 숫자로 변환 후 리스트에 추가
            int tokenToInt = Integer.parseInt(token);
            nums.add(tokenToInt);
        }
        int result = 0;
        for(int num : nums) {
            result += num;
        }
        return result;
    }
}
