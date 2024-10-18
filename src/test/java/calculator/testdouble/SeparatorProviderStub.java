package calculator.testdouble;

import calculator.separatorProvider.SeparatorProvider;
import java.util.List;

public class SeparatorProviderStub implements SeparatorProvider {


    @Override
    public List<Character> extractCustomSeparator(String str) {
        return List.of('(', ')');
    }

    @Override
    public List<Character> getDefaultSeparator() {
        return List.of(':', ',');
    }
}
