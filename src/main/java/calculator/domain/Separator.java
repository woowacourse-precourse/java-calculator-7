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
        // 첫 번째 숫자가 나올 때까지의 부분을 무시하고 나머지를 추출
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // 음수 부호는 뒤에 숫자가 나올 때만 인정
            if (Character.isDigit(c) || (c == '-' && i + 1 < input.length() && Character.isDigit(
                input.charAt(i + 1)))) {
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
                // 음수인지 아닌지를 확인하기 위해 정수 변환 시도
                try {
                    int number = Integer.parseInt(token.trim());
                    separatedNumbers.append(number).append(",");
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("유효하지 않은 입력입니다");
                }
            } else {
                throw new IllegalArgumentException("유효하지 않은 입력입니다");
            }
        }

        // 마지막 쉼표 제거
        if (separatedNumbers.length() > 0) {
            separatedNumbers.setLength(separatedNumbers.length() - 1);
        }
        System.out.println(separatedNumbers.toString());
        return separatedNumbers.toString();
    }
}