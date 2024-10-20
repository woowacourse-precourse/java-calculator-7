package calculator.domain.delimiter;

import static calculator.domain.delimiter.DelimiterPattern.CUSTOM_DELIMITER;

import calculator.util.regex.Regex;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Delimiters {

    private static final String CONTAINING_ALL_START_REGEX = "^.*(";
    private static final String CONTAINING_ALL_END_REGEX = ").*";
    private static final String NON_MATCH = "(?!)";

    private final List<Delimiter> delimiters;

    public Delimiters(final List<Delimiter> delimiters) {
        this.delimiters = delimiters;
    }

    public Delimiters addDelimiter(final Delimiter delimiter) {
        validateDelimiters(delimiter);

        return new Delimiters(concatDelimiters(delimiter));
    }

    public Regex makeDelimiterAreaRegex() {
        Regex regex = new Regex(CUSTOM_DELIMITER.getRegex());
        for (Delimiter delimiter : delimiters) {
            regex.addContinuously(delimiter.delimiter());
        }

        return regex;
    }

    private List<Delimiter> concatDelimiters(final Delimiter delimiter) {

        return Stream.concat(delimiters.stream(), Stream.of(new Delimiter(delimiter.delimiter())))
                .toList();
    }

    private void validateDelimiters(final Delimiter delimiter) {
        checkIfDelimiterContainsOther(delimiter);
    }

    private void checkIfDelimiterContainsOther(final Delimiter newDelimiter) {
        Regex existingDelimitersRegex = makeExistingDelimitersRegex();
        Regex checkContainmentRegex = makeCheckContainmentRegex(existingDelimitersRegex);

        if (newDelimiter.matches(checkContainmentRegex)) {
            throw new IllegalArgumentException("구분자를 중복 선언하거나, 내부에 다른 구분자를 포함할 수 없습니다.");
        }
    }

    private Regex makeExistingDelimitersRegex() {
        Regex existingDelimitersRegex = new Regex(NON_MATCH);
        for (Delimiter existingDelimiter : delimiters) {
            existingDelimitersRegex.addContinuously(existingDelimiter.delimiter());
        }

        return existingDelimitersRegex;
    }

    private Regex makeCheckContainmentRegex(final Regex existingDelimitersRegex) {
        return new Regex(
                CONTAINING_ALL_START_REGEX + existingDelimitersRegex.getRegex() + CONTAINING_ALL_END_REGEX);
    }

    public List<Delimiter> getDelimiters() {
        return Collections.unmodifiableList(delimiters);
    }

}
