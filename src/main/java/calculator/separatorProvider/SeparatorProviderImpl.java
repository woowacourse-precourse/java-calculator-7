package calculator.separatorProvider;

import java.util.HashSet;
import java.util.Set;

public class SeparatorProviderImpl implements SeparatorProvider {

    private static final Set<Character> defaultSeparators = Set.of(':', ',');

    @Override
    public Set<Character> getSeparator(String separatorPart) {
        if (separatorPart != null && !separatorPart.isBlank()) {
            return extractCustomSeparator(separatorPart);
        } else {
            return getDefaultSeparator();
        }
    }

    private Set<Character> extractCustomSeparator(String str) {
        Set<Character> extractedSeparators = new HashSet<>();

        if (str != null && !str.isBlank()) {
            for (char ch : str.toCharArray()) {
                extractedSeparators.add(ch);
            }
        }

        return extractedSeparators;
    }

    private Set<Character> getDefaultSeparator() {
        return defaultSeparators;
    }
}
