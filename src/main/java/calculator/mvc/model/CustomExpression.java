package calculator.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class CustomExpression implements Expression {
    private final int CUSTOM_SEPARATOR_INDEX = 2;
    private final List<Character> DEFAULT_SEPARATOR = List.of(',', ':');
    private final String CUSTOM_PREFIX = "//";
    private final String CUSTOM_SUFFIX = "\\n";
    private List<Character> separators = new ArrayList<>();

    public CustomExpression() {
        for (Character c : DEFAULT_SEPARATOR) {
            separators.add(c);
        }
    }

    private void findCustomSeparator(String input) throws IllegalStateException {
        if (existCustomSeparator(input)) {
            if ('0' <= input.charAt(CUSTOM_SEPARATOR_INDEX) && input.charAt(CUSTOM_SEPARATOR_INDEX) <= '9') {
                throw new IllegalArgumentException("커스텀 구분자로 숫자를 입력할 수 없습니다.");
            }

            separators.add(input.charAt(CUSTOM_SEPARATOR_INDEX));
        }
    }

    private boolean existCustomSeparator(String input) throws IllegalStateException {
        if (input.startsWith(CUSTOM_PREFIX)) {
            if (input.indexOf(CUSTOM_SUFFIX) == -1) {
                throw new IllegalArgumentException("\"\\n\"가 문자열에 존재하지 않습니다.");
            }

            if (input.indexOf(CUSTOM_SUFFIX) > CUSTOM_SEPARATOR_INDEX + 1) {
                throw new IllegalArgumentException("길이 1인 커스텀 구분자를 입력하지 않았습니다.");
            }

            if (input.indexOf(CUSTOM_SUFFIX) == CUSTOM_SEPARATOR_INDEX + 1) {
                return true;
            }
        }

        return false;
    }

    public String makeExpression(String input) {
        findCustomSeparator(input);

        StringBuilder regExTmp = new StringBuilder();

        regExTmp.append("[");
        for (int i = 0; i < separators.size(); i++) {
            if (separators.get(i) == '\\' || separators.get(i) == '[' || separators.get(i) == ']') {
                regExTmp.append('\\').append(separators.get(i));
                continue;
            }

            regExTmp.append(separators.get(i));
        }
        regExTmp.append("]");

        return regExTmp.toString();
    }
}
