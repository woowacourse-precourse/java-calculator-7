package calculator.domain;

import calculator.common.exception.InvalidSeparatorException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Separators {

    private Set<Character> separators;
    private String delimiter;

    /*
     * 기본 구분자를 정의합니다.
     */
    public Separators() {
        separators = new HashSet<>(Arrays.asList(':', ','));
    }

    /*
     * 커스텀 구분자가 있을 경우 커스텀 구분자를 구분자 리스트에 추가합니다.
     * 이때 커스텀 구분자가 올바른지 검증합니다.
     */
    public void addCustomSeparator(Character customSeparator) {
        validateSeparator(customSeparator);
        separators.add(customSeparator);
    }

    /*
     * 구분자 리스트로 정규 표현식을 만들어 반환합니다.
     */
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
