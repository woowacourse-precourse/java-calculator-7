package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterGenerator {

    private static final String DELIMITER_PATTERN = "//(.)\\\\n(.*)";
    private static final char DEFAULT_DELIMITER1 = ',';
    private static final char DEFAULT_DELIMITER2 = ':';

    public static DelimiterInputDTO generateDelimiterInputDTO(String input) {

        DelimiterInputDTO delimiterInputDTO = new DelimiterInputDTO(input);

        List<Character> delimiters = createDefaultDelimiters();

        Matcher delimiterFormat = getDelimiterFormat(input);
        if (delimiterFormat.matches()) {
            updateDelimiterInputDTO(delimiterInputDTO, delimiterFormat, delimiters);
        }

        delimiterInputDTO.setDelimiter(delimiters);

        return delimiterInputDTO;

    }

    private static void updateDelimiterInputDTO(DelimiterInputDTO delimiterInputDTO, Matcher delimiterFormat,
                                                List<Character> delimiters) {
        delimiterInputDTO.setInput(delimiterFormat.group(2));
        delimiters.add(delimiterFormat.group(1).charAt(0));
    }

    private static List<Character> createDefaultDelimiters() {
        return new ArrayList<>(List.of(DEFAULT_DELIMITER1, DEFAULT_DELIMITER2));
    }

    private static Matcher getDelimiterFormat(String input) {
        Pattern delimiterFormatPattern = Pattern.compile(DELIMITER_PATTERN);
        return delimiterFormatPattern.matcher(input);
    }
}
