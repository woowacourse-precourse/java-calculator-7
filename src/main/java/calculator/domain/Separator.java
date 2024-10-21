package calculator.domain;

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
        if (input.contains("\\n")) {
            input = input.substring(input.indexOf("\\n") + 2);
        }

        //문자열 맨 앞 또는 맨 뒤에 구분자가 오는경우 예외처리
        if (input.startsWith(delimiters.get(0)) || input.endsWith(
            delimiters.get(delimiters.size() - 1))) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }

        String delimiterRegex = String.join("|", delimiters);
        String[] tokens = input.split(delimiterRegex);

        // 각 토큰을 공백 없이 연결된 하나의 문자열로 반환
        StringBuilder separatedNumbers = new StringBuilder();
        for (String token : tokens) {
            if (!token.isEmpty()) {
                String trimmedToken = token.trim();

                // 공백이 있는지 확인
                if (token.length() != trimmedToken.length()) {
                    throw new IllegalArgumentException("입력에 공백이 포함되어 있습니다: " + token);
                }

                try {
                    int number = Integer.parseInt(trimmedToken);
                    separatedNumbers.append(number).append(",");
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("유효하지 않은 입력입니다: " + token + "는 숫자가 아닙니다.");
                }
            } else {
                throw new IllegalArgumentException("유효하지 않은 숫자가 포함되어 있습니다.");
            }
        }

        // 마지막 쉼표 제거
        if (separatedNumbers.length() > 0) {
            separatedNumbers.setLength(separatedNumbers.length() - 1);
        }

        return separatedNumbers.toString();
    }
}