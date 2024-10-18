package calculator.utils;

import calculator.domain.Candidate;
import calculator.domain.delimiter.Delimiter;
import java.util.List;
import java.util.regex.Pattern;

public class RegexUtils {

    private static final String INPUT_FORMAT = "^(//|[0-9].*).*|^$";
    private static final String NUMBER_FORMAT = "^[1-9][0-9]*$";

    public static String makeAllOfDelimiters(List<Delimiter> delimiters) {
        StringBuilder sb = new StringBuilder();
        for (Delimiter d : delimiters) {
            sb.append(d.getDelimiter())
                    .append("|");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static boolean isMatchedInput(String input) {
        return Pattern.matches(INPUT_FORMAT, input);
    }

    public static boolean isMatchedNumber(Candidate candidate) {
        return Pattern.matches(NUMBER_FORMAT, candidate.getCandidate());
    }
}
