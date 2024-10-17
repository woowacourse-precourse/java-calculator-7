package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Delimiter {

    /**
     * 기본 구분자(쉼표, 콜론) 처리
     */
    public String[] defaultDelimiter(String input) {
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
    public String[] customDelimiter(String input) {
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
