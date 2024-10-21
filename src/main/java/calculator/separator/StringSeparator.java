package calculator.separator;

import calculator.utils.ListConverterUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeparator {

    private String basicString;
    private String delimiters;

    private final String BASIC_DELIMITERS = ":,";
    private final String CUSTOM_DELIMITER_START = "//";
    private final String CUSTOM_DELIMITER_END = "\\\\n";
    private final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(
            "^" + CUSTOM_DELIMITER_START + "(\\D*)" + CUSTOM_DELIMITER_END + ".*");


    public StringSeparator(String basicString) {
        this.basicString = basicString;
        this.delimiters = BASIC_DELIMITERS;
    }

    public StringSeparator() {
        this.delimiters = BASIC_DELIMITERS;
    }


    public boolean validCustomDelimiters() {
        return CUSTOM_DELIMITER_PATTERN.matcher(basicString).matches();
    }

    public String extractCustomDelimiters() {
        String extractedCustomDelimiters = "";
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(basicString);
        if (matcher.find()) {
            extractedCustomDelimiters = matcher.group(1);
        }
        return extractedCustomDelimiters;
    }

    public String addCustomDelimiters(String customDelimiters) {
        return delimiters += customDelimiters;
    }

    public String splitCustomDelimiters() {
        return basicString = basicString.split(CUSTOM_DELIMITER_END)[1];
    }

    public String separateCustomDelimiter() {
        String separtatedString = basicString;
        if (validCustomDelimiters()) {
            String customDelimiters = extractCustomDelimiters();
            addCustomDelimiters(customDelimiters);
            separtatedString = splitCustomDelimiters();
        }
        return separtatedString;
    }

    public List<String> splitBasicStringWithDelimiters() {
        StringTokenizer st = new StringTokenizer(basicString, delimiters);
        List<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        return tokens;
    }

    public List<String> separate() {
        separateCustomDelimiter();
        return splitBasicStringWithDelimiters();
    }
}
