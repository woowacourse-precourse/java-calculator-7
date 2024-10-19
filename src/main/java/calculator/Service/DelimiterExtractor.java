package calculator.Service;
import calculator.DTO.StringCalculatorDTO;
import java.util.ArrayList;
import java.util.List;

public class DelimiterExtractor {
    // 문자열을 특정 구분자를 기준으로 분리하는 메서드
    public List<String> extractDelimiter (StringCalculatorDTO inputDTO) {
        String input = inputDTO.getInput();
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        // 인덱스를 관리하면서 문자 탐색
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == ',' || ch == ':') {
                result.add(current.toString()); // 구분자를 만나면 현재까지 쌓은 문자열을 리스트에 추가
                current.setLength(0);           // StringBuilder 초기화
            } else {
                current.append(ch);             // 구분자가 아니면 StringBuilder에 해당 문자를 추가
            }
        }

        // 마지막으로 남아있는 문자열 추가
        if (current.length() > 0) {
            result.add(current.toString());
        }

        return result; // 기본 구분자로 분리된 문자열들을 반환
    }
}
