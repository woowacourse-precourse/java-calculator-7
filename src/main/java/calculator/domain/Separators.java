package calculator.domain;

import calculator.common.exception.InvalidSeparatorException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Separators {

    private Set<Character> separators;
    private String delimiter;

    public Separators() {
        separators = new HashSet<>(Arrays.asList(':', ','));
    }

    public void addCustomSeparator(Character customSeparator) {
        validateSeparator(customSeparator);
        separators.add(customSeparator);
    }

    public String getDelimiter() {
        if (delimiter == null) {
            makeDelimiter();
        }
        return this.delimiter;
    }

    private void makeDelimiter() {
        StringBuilder delimiter = new StringBuilder();
        delimiter.append("[");
        for (Character separator : this.separators) {
            if (separator == '-' || separator == '[' || separator == ']') {
                delimiter.append("\\");
            }
            delimiter.append(separator);
        }
        delimiter.append("]");
        this.delimiter = delimiter.toString();
    }

    private void validateSeparator(Character separator) {
        if (Character.isDigit(separator)) {
            throw new InvalidSeparatorException(separator);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Separators that = (Separators) o;
        return Objects.equals(separators, that.separators) && Objects.equals(delimiter, that.delimiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(separators, delimiter);
    }
}
