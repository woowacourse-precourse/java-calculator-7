package calculator.model;

import calculator.domain.Candidate;
import calculator.utils.RegexUtils;
import java.util.List;

public class Validator {
    public void execute(String input, List<Candidate> candidates) {
        if (!validateInput(input) || !validateNumbers(candidates)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean validateInput(String input) {
        return RegexUtils.isMatchedInput(input);
    }

    private boolean validateNumbers(List<Candidate> candidates) {
        return candidates.stream()
                .allMatch(RegexUtils::isMatchedNumber);
    }
}
