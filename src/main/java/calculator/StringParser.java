package calculator;

import calculator.customSeparatorExtractor.CustomSeparatorExtractor;
import calculator.numberExtractor.NumberExtractor;
import java.util.ArrayList;
import java.util.List;

public class StringParser {

    private final List<Character> separators = new ArrayList<>();
    private final CustomSeparatorExtractor customSeparatorExtractor;
    private final NumberExtractor numberExtractor;

    public StringParser(
            CustomSeparatorExtractor customSeparatorExtractor,
            NumberExtractor numberExtractor
    ) {
        this.customSeparatorExtractor = customSeparatorExtractor;
        this.numberExtractor = numberExtractor;
        addDefaultSeparators();
    }

    public List<Character> getSeparators() {
        return separators;
    }

    public List<Integer> parse(String customSeparatorString, String numberString) {
        List<Character> customSeparators = customSeparatorExtractor.extract(customSeparatorString);
        separators.addAll(customSeparators);

        return numberExtractor.extract(numberString, separators);
    }

    private void addDefaultSeparators() {
        separators.add(',');
        separators.add(':');
    }
}
