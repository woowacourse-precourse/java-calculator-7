package calculator;

import java.util.Arrays;
import java.util.List;

public class Splitter {

    public List<String> splitByBasicSeparator(String value) {
        return Arrays.stream(value.split("[,:]")).toList();

    }

    public List<String> splitByCustomSeparator(String value, List<String> customSeparators) {
        StringBuilder sb = new StringBuilder();
        customSeparators.forEach(s -> sb.append(s).append("|"));
        sb.deleteCharAt(sb.length() - 1);

        return Arrays.stream(value.split(sb.toString())).toList();
    }
}
