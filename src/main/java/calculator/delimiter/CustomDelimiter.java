package calculator.delimiter;

public class CustomDelimiter implements Delimiter {

    private final char value;

    public CustomDelimiter(char value) {
        this.value = value;
    }

    public CustomDelimiter(String str) {
        if (str.length() != 1) {
            throw new IllegalArgumentException("구분자는 문자만 가능합니다.");
        }
        this.value = str.charAt(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomDelimiter separator = (CustomDelimiter) o;
        return value == separator.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
