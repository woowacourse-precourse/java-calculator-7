package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputString {
    private final String inputString;

    public InputString(String inputString) {
        this.inputString = inputString;
    }

    public boolean isBlank() {
        return inputString.isBlank();
    }

    public boolean containsCustomSeperator() {
        return inputString.startsWith("//");
    }

    public boolean notContainsCustomSeperator() {
        Pattern compile = Pattern.compile("^\\d.*");
        Matcher matcher = compile.matcher(inputString);
        return matcher.matches();  // 숫자로 시작하는지
    }

    public List<String> extractCustomSeperator() {
        List<String> list = new ArrayList<>();

        Pattern compile = Pattern.compile("^//([^0-9])\\\\n(.*)");
        Matcher matcher = compile.matcher(inputString);

        validateCustomDelimiter(inputString);

        if (matcher.matches()) {
            list.add(matcher.group(1));  // 커스텀 구분자 추출
            list.add(matcher.group(2));  // 나머지 숫자 부분
        } else {
            throw new IllegalArgumentException("커스텀 구분자를 올바르게 지정하지 않았습니다.");
        }

        return list;
    }

    public static void validateCustomDelimiter(String inputString) {
        if (!inputString.contains("\\n")) {
            throw new IllegalArgumentException("'\\n'로 커스텀 구분자를 지정해야 합니다.");
        }

        int delimiterStart = inputString.indexOf("//") + 2;
        int delimiterEnd = inputString.indexOf("\\n");
        String delimiter = inputString.substring(delimiterStart, delimiterEnd);

        if (delimiter.length() > 1) {
            throw new IllegalArgumentException("'//'와 '\\n' 사이에 하나의 구분자만 있어야 합니다.");
        }

        if (delimiter.isEmpty() || delimiter.trim().isEmpty()) {
            throw new IllegalArgumentException("'//'와 '\\n' 사이에 유효한 구분자가 있어야 합니다.");
        }

        if (delimiter.equals(",") || delimiter.equals(":")) {
            throw new IllegalArgumentException("구분자로 쉼표(,) 또는 콜론(:)은 사용할 수 없습니다.");
        }
    }

    public String getInputString() {
        return inputString;
    }
}
