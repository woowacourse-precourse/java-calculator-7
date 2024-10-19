package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Splitter {

    public List<String> splitByBasicSeparator(String value) {
        return Arrays.stream(value.split("[,:]")).toList();

    }

    public List<String> splitByCustomSeparator(String value, List<String> customSeparators) {
        if (customSeparators.isEmpty()) {
            return List.of(value);
        }

        StringBuilder sb = new StringBuilder();

        customSeparators.forEach(s -> sb.append(Pattern.quote(s)).append("|"));

        // 마지막 구분자의 '|' 제거
        sb.deleteCharAt(sb.length() - 1);

        return Arrays.stream(value.split(sb.toString())).toList();
    }
}
