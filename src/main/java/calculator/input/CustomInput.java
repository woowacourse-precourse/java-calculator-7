package calculator.input;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class CustomInput {
    // 커스텀 구분자로 파싱
    public int customParseSum(String input){
        // 구분자를 찾기 위해 문자열 \\n으로 나누기
        String[] parts = input.split("\\\\n", 2);

        // 첫 번째 줄에서 구분자 설정
        String delimiter = parts[0].substring(2).trim(); // 구분자는 "//" 다음부터의 문자열

        // 구분자가 없을 경우 예외 처리
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException("구분자가 없습니다.");
        }

        String numbersPart = parts[1]; // 나머지 문자열

        // 구분자로 숫자들을 나누기
        String[] numbers = numbersPart.split(delimiter);
        int result = 0;

        for (String number : numbers) {
            // 빈 문자열이 아닌 경우에만 숫자 합산
            if (!number.isEmpty()) {
                result += Integer.parseInt(number.trim()); // 공백 제거 후 정수 변환
            }
        }

        return result;
    }
}