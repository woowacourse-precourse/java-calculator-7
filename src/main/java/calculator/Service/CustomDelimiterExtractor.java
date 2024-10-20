package calculator.Service;

import calculator.DTO.StringCalculatorDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterExtractor {

    // 문자열을 커스텀 구분자를 기준으로 분리하는 메서드
    public List<String> extractDelimiter(StringCalculatorDTO inputDTO) {
        List<String> detachedInputList = inputDTO.getDetachedInput();
        List<String> result = new ArrayList<>();

        // 첫 번째 요소에서 커스텀 구분자를 추출
        char delimiter = ',';
        String content = "";

        // 첫 번째 요소에 커스텀 구분자가 있는지 확인
        Matcher matcher = Pattern.compile("//(.)\\\\n").matcher(detachedInputList.get(0));
        if (matcher.find()) {
            // 커스텀 구분자 추출
            delimiter = matcher.group(1).charAt(0);

            // 첫 번째 요소에서 본문 내용 추출
            content = detachedInputList.get(0).substring(matcher.end());
        }

        // 첫 번째 요소의 본문 데이터 처리
        result.addAll(extractCustomDelimiter(content, delimiter));

        // 나머지 요소 처리 (커스텀 구분자를 동일하게 적용)
        for (int i = 1; i < detachedInputList.size(); i++) {
            result.addAll(extractCustomDelimiter(detachedInputList.get(i), delimiter));
        }

        return result;
    }

    // 커스텀 구분자로 문자열을 분리하는 메서드
    public List<String> extractCustomDelimiter(String input, char delimiter) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        // 본문 문자열을 순회하며 커스텀 구분자로 분리
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == delimiter) {
                result.add(current.toString()); // 구분자를 만나면 현재까지 쌓은 문자열을 리스트에 추가
                current.setLength(0);           // StringBuilder 초기화
            } else {
                current.append(ch);             // 구분자가 아니면 StringBuilder에 추가
            }
        }

        // 마지막 남은 문자열 추가
        if (current.length() > 0) {
            result.add(current.toString());
        }
        return result;
    }
}
