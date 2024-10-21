package stringprocess;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

class Splitter {

    private final String basicSeparatorRegex;

    private List<String> customSeparators;

    public Splitter(String basicSeparatorRegex, List<String> customSeparators) {
        this.basicSeparatorRegex = basicSeparatorRegex;
        this.customSeparators = customSeparators;
    }

    public List<String> splitByBasicSeparator(String value) {
        return Arrays.stream(value.split(basicSeparatorRegex)).toList();

    }

    public List<String> splitByCustomSeparator(String value) {
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
