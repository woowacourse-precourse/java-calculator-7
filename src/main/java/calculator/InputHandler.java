package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputHandler {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String EXTRACT_DELIMITER_REGEX = "//(.*?)\\\\n";

    public String inputString() {
        return Console.readLine();
    }

    public List<Integer> extractNumbers(String input) {
        List<String> parsedString = parseString(input);

        return parsedString.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<String> parseString(String str) {
        String customDelimiter = extractCustomDelimiter(str);
        if (customDelimiter != null) {
            String inputString = str.replaceAll(EXTRACT_DELIMITER_REGEX, "");
            String[] result = inputString.split(customDelimiter);
            return Arrays.asList(result);
        }

        String[] result = str.split(DEFAULT_DELIMITER_REGEX);
        return Arrays.asList(result);
    }

    private String extractCustomDelimiter(String str) {
        Pattern pattern = Pattern.compile(EXTRACT_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }
}
