package calculator.entity;

import static calculator.utils.Constants.COLON;
import static calculator.utils.Constants.COMMA;

import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

public class Separator {

    private final String sep;

    public Separator(String separator) {
        Set<String> validSeparators = Set.of(COMMA, COLON);

        if (validSeparators.contains(separator)) {
            throw new IllegalArgumentException("Separator should not be comma or colon");
        }

        if (separator.length() > 2) {
            throw new IllegalArgumentException("Separator should be a single character");
        }

        String quote = Pattern.quote(separator);
        this.sep = quote;
    }

    protected static String toRegexString(Set<Separator> separatorSet) {
        StringBuilder sb = new StringBuilder();

        sb.append(COLON);
        sb.append(COMMA);

        for (Separator separator : separatorSet) {
            String v = separator.sep;
            sb.append(v);
        }

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
        String compareSep = ((Separator) o).sep;
        return Objects.equals(sep, compareSep);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sep);
    }
}
