package calculator.testdouble;

import calculator.separatorProvider.SeparatorProvider;
import java.util.Set;

public class SeparatorProviderStub implements SeparatorProvider {


    @Override
    public Set<Character> extractCustomSeparator(String str) {
        return Set.of('(', ')');
    }

    @Override
    public Set<Character> getDefaultSeparator() {
        return Set.of(':', ',');
    }
}
