package calculator.entity;

import java.util.Objects;

public class RegexStr {

    private final String regex;

    public RegexStr(String regex) {
        this.regex = regex;
    }

    @Override
    public String toString() {
        return "[" + regex + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RegexStr regexStr = (RegexStr) o;
        return Objects.equals(regex, regexStr.regex);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(regex);
    }
}
