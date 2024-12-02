package calculator;

import java.util.List;

public class CustomSeparatorSplit implements Splitor {
    private final String str;
    private final String separator;

    CustomSeparatorSplit(String str, String separator) {
        this.str = str;
        this.separator = separator;
    }

    @Override
    public List<String> split() {
        return List.of(str.split(separator));
    }
}
