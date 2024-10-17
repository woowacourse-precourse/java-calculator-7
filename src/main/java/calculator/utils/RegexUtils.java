package calculator.utils;

import calculator.domain.delimiter.Delimiter;

import java.util.List;

public class RegexUtils {
    public static String makeAllOfDelimiters(List<Delimiter> delimiters) {
        StringBuilder sb = new StringBuilder();
        for (Delimiter d : delimiters) {
            sb.append(d.getDelimiter())
                    .append("|");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
