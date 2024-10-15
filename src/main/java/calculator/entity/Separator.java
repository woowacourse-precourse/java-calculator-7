package calculator.entity;

import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

public class Separator {

    private static final String COMMA = ",";
    private static final String COLON = ":";
    private final String sep;

    public Separator(String separator) {
        if (separator.equals(COMMA) || separator.equals(COLON)) {
            throw new IllegalArgumentException("Separator should not be comma or colon");
        }

        if (separator.length() > 2) {
            throw new IllegalArgumentException("Separator should be a single character");
        }
        this.sep = separator;
    }

    public static String getAllSeparators(Set<Separator> separatorSet) {
        StringBuilder sb = new StringBuilder("[");
        sb.append(COLON);
        sb.append(COMMA);
        for (Separator separator : separatorSet) {
            String regex = Pattern.quote(separator.sep);
            sb.append(regex);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Separator{" +
            "sep='" + sep + '\'' +
            '}';
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
        return Objects.equals(sep, separator.sep);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sep);
    }
}
