package calculator.service;

import calculator.ui.UserInputMessage;
import java.util.Objects;

public class NumberService {

    public String doService(final UserInputMessage userInputMessage) {
        final UserInputNumbers userInputNumbers = userInputMessage.getUserInputNumber();
        final UserInputSeparator userInputSeparator = userInputMessage.getUserInputSeparator();
        final Tokenizer tokenizer = userInputNumbers.getTokenizer(new DefaultSeparatorFactory());
        if (Objects.nonNull(userInputSeparator)) {
            tokenizer.addSeparator(new CharacterSequenceSeparator(userInputSeparator.getSeparator()));
        }
        final Numbers numbers = tokenizer.tokenize();
        return numbers.getSum();
    }
}