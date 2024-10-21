package calculator.testdouble;

import calculator.separatorProvider.SeparatorProvider;
import java.util.Set;

public class SeparatorProviderStub implements SeparatorProvider {

    @Override
    public Set<Character> getSeparator(String separatorPart) {
        return Set.of(':', ',');
    }
}
