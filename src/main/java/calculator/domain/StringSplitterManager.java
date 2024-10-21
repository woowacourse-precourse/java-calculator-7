package calculator.domain;

import calculator.domain.stringsplitter.StringSplitter;

import java.util.List;

public class StringSplitterManager {

    private final List<StringSplitter> stringSplitters;

    public StringSplitterManager(List<StringSplitter> stringSplitters) {
        this.stringSplitters = stringSplitters;
    }

    public List<String> getSplitStrings(String str) {
        StringSplitter stringSplitter = stringSplitters.stream()
                .filter(splitter -> splitter.canSupport(str))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(str));

        return stringSplitter.splitString(str);
    }
}
