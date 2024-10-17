package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Delimiter {
    private final String input;

    public Delimiter(String input) {
        this.input = input;
    }

    /**
     * 구분자를 통해 문자열을 파싱
     */
    public String[] extractNumbers() {
        if (input.startsWith("//")) {
            return customDelimiter();
        } else {
            return defaultDelimiter();
        }
    }

    /**
     * 기본 구분자(쉼표, 콜론) 처리
     */
    private String[] defaultDelimiter() {
        String[] commaSplit = input.split(",");
        List<String> result = new ArrayList<>();

        for (String part : commaSplit) {
            String[] colonSplit = part.split(":");
            result.addAll(Arrays.asList(colonSplit));
        }

        return result.toArray(new String[0]);
    }

    /**
     * 커스텀 구분자 처리
     */
    private String[] customDelimiter() {
        int start = input.lastIndexOf("/");
        int end = input.indexOf("\\n");
        String delimiter = input.substring(start + 1, end);

        // 파이프(|) 문자 처리
        if ("|".equals(delimiter)) {
            delimiter = "\\|";
        }

        String part = input.substring(end + 2);
        return part.split(delimiter);
    }
}
