package calculator;

public class Separator {

    private final char value;

    public Separator(char value) {
        this.value = value;
    }

    public Separator(String str) {
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

        Separator separator = (Separator) o;
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
