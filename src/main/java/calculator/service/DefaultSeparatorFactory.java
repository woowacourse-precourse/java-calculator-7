package calculator.service;

import java.util.List;

class DefaultSeparatorFactory implements SeparatorFactory {

    @Override
    public List<NumberSeparator> getSeparators() {
        return List.of(
                new CharacterSequenceSeparator(":"),
                new CharacterSequenceSeparator(",")
        );
    }
}
