package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Extractor {

    private List<Character> delimiters = new ArrayList<>(Arrays.asList(',', ':'));
    private boolean isCustomDelimiter = false;

    public void extractCustomDelimiter(String input) {
        if (input.startsWith("//") && input.substring(3, 5).equals("\\n")) {
            char delimiter = input.charAt(2);

            isNumber(delimiter);

            delimiters.add(delimiter);
            isCustomDelimiter = true;
        }
    }

    public void extractNumbers(String input, List<Long> numbers) {

        input = removeCustomDelimiter(input);

        String regex = makeRegex();

        // 구분자를 기준으로 문자열을 숫자들로 분리
        // 이때 구분자가 아닌 문자가 포함되어 있을 수 있는데, 숫자인지 확인하는 메소드에서 걸러짐
        String[] tokens = input.split(regex);
        for (String token : tokens) {
            if (!token.isEmpty()) {
                Long number = validateIsNumber(token);
                validateNegativeNumber(number);
                numbers.add(number);
            }
        }
    }

    private void isNumber(char input) {
        if (Character.isDigit(input)) {
            throw new IllegalArgumentException("숫자인 구분자는 사용할 수 없습니다.");
        }
    }

    //커스텀 구분자를 제거하는 메소드
    private String removeCustomDelimiter(String input) {
        if (isCustomDelimiter) {
            input = input.substring(5);
        }
        return input;
    }

    //구분자를 생성하는 메소드
    private String makeRegex() {
        StringBuilder regex = new StringBuilder("[");
        for (char delimiter : delimiters) {
            regex.append("\\").append(delimiter);
        }
        regex.append("]");

        return regex.toString();
    }

    //분리한 문자열이 숫자인지 확인하는 메소드
    private Long validateIsNumber(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    //음수인지 확인하는 메소드
    private void validateNegativeNumber(Long number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수가 포함되어 있습니다.");
        }
    }

}
