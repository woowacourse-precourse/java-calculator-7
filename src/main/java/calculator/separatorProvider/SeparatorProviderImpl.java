package calculator.separatorProvider;

import java.util.ArrayList;
import java.util.List;

public class SeparatorProviderImpl implements SeparatorProvider {

    private static final List<Character> defaultSeparators = List.of(':', ',');

    @Override
    public List<Character> extractCustomSeparator(String str) {
        List<Character> extractedSeparators = new ArrayList<>();

        if (str != null && !str.isBlank()) {
            for (char ch : str.toCharArray()) {
                extractedSeparators.add(ch);
            }
        }

        return extractedSeparators;
    }

    @Override
    public List<Character> getDefaultSeparator() {
        return defaultSeparators;
    }
}
