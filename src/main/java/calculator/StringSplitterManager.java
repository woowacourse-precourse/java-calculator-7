package calculator;

import java.util.List;

public class StringSplitterManager {

    private final List<StringSplitter> stringSplitters;
    private final String string;

    public StringSplitterManager(List<StringSplitter> stringSplitters, String string) {
        this.stringSplitters = stringSplitters;
        this.string = string;
    }

    public List<String> getSplitStrings() {
        StringSplitter stringSplitter = stringSplitters.stream()
                .filter(splitter -> splitter.canSupport(string))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(string));

        return stringSplitter.splitString(string);
    }
}
