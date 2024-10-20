package calculator.input;
import java.util.ArrayList;

public class CustomInput {
    public int customParseSum(String input) {
        // 구분자를 찾기 위해 문자열 \n으로 나누는 과정이 필요
        // \n을 기준으로 구분자와 숫자로 이루어진 문자열. 두 파트로 나누어 줄 것임.
        String[] parts = input.split("\\\\n", 2);

        // 첫 파트는 구분자 설정. 맨 앞에 있는 //를 자르면 구분자만 남는다.
        String delimiterPart = parts[0].substring(2).trim();

        // 두 번째 파트는 숫자로 이루어진 문자열.
        String numberPart = parts[1];

        // 구분자로 숫자 나누기
        String[] numbers = numberPart.split(delimiterPart);
        int result = 0;

        for(String number : numbers) {
            // 빈 문자열이 아닌 경우에만 숫자 합산
            result += Integer.parseInt(number);
        }
        return result;
    }
}
