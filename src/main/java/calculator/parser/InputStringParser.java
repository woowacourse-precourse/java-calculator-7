package calculator.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputStringParser {

    public List<Long> parse(String input) throws IllegalArgumentException{

        Optional<String> customIdentifier = parseCustomIdentifier(input);
        if (customIdentifier.isPresent()) {
            String resizedString = resizeString(input);
            String customIdentifierRegex = createRegexfromString(customIdentifier.get());
            System.out.println(resizedString);
                return convertStringToList(resizedString, customIdentifierRegex);
        } else {
                return convertStringToList(input, ", | :");
        }
    }

    private List<Long> convertStringToList(String input, String regex) {
        try {
            return Arrays
                    .stream(input.split(regex))
                    .map(Long::parseLong)
                    .toList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private String createRegexfromString(String input) {
        StringBuilder regexStringBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            regexStringBuilder.append("\\");
            regexStringBuilder.append(input.charAt(i));
        }
        return regexStringBuilder.toString();
    }

    private String resizeString(String input) {

        Matcher matcher = regexMatcherCustomIdentifier(input);
        if (matcher.find()) {
            return input.substring(matcher.end());
        } else {
            throw new IllegalArgumentException();
        }
    }

    private Optional<String> parseCustomIdentifier(String input) {

        Matcher matcher = regexMatcherCustomIdentifier(input);

        if(matcher.find()) {
            return Optional.of(matcher.group(1));
        } else {
            return Optional.empty();
        }
    }

    private Matcher regexMatcherCustomIdentifier(String input) {
        Pattern pattern = Pattern.compile("^//(.*)\\\\n");
        return pattern.matcher(input);
    }
}
