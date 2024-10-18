package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class Separator {

    private DelimiterManager delimiterManager;

    // 생성자를 통해 DelimiterManager 주입
    public Separator(DelimiterManager delimiterManager) {
        this.delimiterManager = delimiterManager;
    }

    // 입력 문자열을 구분자를 기준으로 분리하여 숫자를 추출하는 메서드
    public String extractNumbers(String input) {
        // 사용할 구분자 리스트를 DelimiterManager에서 가져옴
        List<String> delimiters = delimiterManager.getDelimiters(input);

        // 구분자 리스트를 기반으로 입력 문자열을 분리
        return splitByDelimiters(input, delimiters);
    }

    // 구분자를 사용하여 숫자를 분리하는 메서드
    private String splitByDelimiters(String input, List<String> delimiters) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c) || c == '-') {
                // 첫 숫자가 발견되면 해당 위치부터 끝까지의 문자열을 반환
                input = input.substring(i);
                break;
            }
        }

        String delimiterRegex = String.join("|", delimiters);
        String[] tokens = input.split(delimiterRegex);

        System.out.println(Arrays.toString(tokens));

        // 각 토큰을 공백 없이 연결된 하나의 문자열로 반환
        StringBuilder separatedNumbers = new StringBuilder();
        for (String token : tokens) {
            if (!token.isEmpty()) {
                separatedNumbers.append(token.trim()).append(",");
            }
        }

        // 마지막 쉼표 제거
        if (separatedNumbers.length() > 0) {
            separatedNumbers.setLength(separatedNumbers.length() - 1);
        }
        return separatedNumbers.toString();
    }
}