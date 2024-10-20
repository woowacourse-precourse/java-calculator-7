package calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Splitter {

    private final HashSet<Character> separators = new HashSet<>();
    private static final String prefix = "//";
    private static final String suffix = "\\n";

    public Splitter() {
        separators.add(',');
        separators.add(':');
    }

    public List<String> split(String target) {

        List<String> tokens = new ArrayList<>();
        String token = "";

        for (char ch : target.toCharArray()) {
            if (separators.contains(ch)) {
                tokens.add(token);
                token = "";
            }
            else if (Character.isDigit(ch))
                token += ch;
            else
                throw new IllegalArgumentException("숫자와 구분자 이외의 값은 입력할 수 없습니다.");
        }
        tokens.add(token);

        return tokens;
    }

    public String splitCustomSeparators(String inputValue) {
        if (!inputValue.startsWith(prefix))
            return inputValue;

        int suffixIndex = inputValue.indexOf(suffix);
        for (Character token : inputValue.substring(prefix.length(), suffixIndex).toCharArray())
            separators.add(token);

        return inputValue.substring(suffixIndex + suffix.length());
    }
}
