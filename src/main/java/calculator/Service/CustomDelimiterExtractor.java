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
        
        // 각 문자열에서 커스텀 구분자를 찾아 처리
        for (String input : detachedInputList) {
            // 정규식을 이용해 커스텀 구분자 탐색
            Matcher matcher = Pattern.compile("//(.)\\\\n").matcher(input);
            if (matcher.find()) {
                // 커스텀 구분자를 추출
                char delimiter = matcher.group(1).charAt(0);
                System.out.println("커스텀 구분자 딜리미터 : " + delimiter);
                // \\n 이후의 본문 문자열을 추출
                String content = input.substring(matcher.end());
                System.out.println("커스텀 구분자 추출 후 본문 : " + content);
                // 본문을 커스텀 구분자로 분리하고 결과 리스트에 추가
                result.addAll(extractCustomDelimiter(content, delimiter));
            }
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
        System.out.println("custom : " + result);
        return result;
    }
}
