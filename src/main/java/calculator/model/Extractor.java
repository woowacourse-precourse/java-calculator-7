package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Extractor {

    private List<Character> delimiters = new ArrayList<>(Arrays.asList(',', ':'));
    private boolean isCustomDelimiter = false;

    public void extractCustomDelimiter(String input, List<Character> delimiters) {
        if(input.startsWith("//") && input.substring(3,5).equals("\\n")){
            delimiters.add(input.charAt(2));
            isCustomDelimiter = true;
        }
    }

    public void extractNumbers(String input, List<Long> numbers) {

        input = removeCustomDelimiter(input);

        String regex = makeRegex();

        // 구분자를 기준으로 문자열을 숫자들로 분리
        String[] tokens = input.split(regex);
        for (String token : tokens) {
            if (!token.isEmpty()) {
                Long number = validateIsNumber(token);
            }
        }
    }

    //커스텀 구분자를 제거하는 메소드
    private String removeCustomDelimiter(String input) {
        if(isCustomDelimiter) {
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

    private Long validateIsNumber(String input) {
        try{
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

}
