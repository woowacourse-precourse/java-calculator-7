package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputStringParser {

    public List<Long> parse(String input) throws IllegalStateException{

        Optional<String> customIdentifier = parseCustomIdentifier(input);
        try {

            if (customIdentifier.isPresent()) {
                String resizedSTring = resizeString(input);
                return convertStringToList(resizedSTring, customIdentifier.get());
            } else {
                return convertStringToList(input, ", | :");
            }

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

    }

    private List<Long> convertStringToList(String input, String regex) {
        return Arrays
                .stream(input.split(regex))
                .map(Long::parseLong)
                .toList();
    }

    private String resizeString(String input) {
        Pattern pattern = Pattern.compile("^//(.*)\\\\n");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return input.substring(matcher.end());
        } else {
            throw new IllegalStateException();
        }
    }

    private Optional<String> parseCustomIdentifier(String input) {
        Pattern pattern = Pattern.compile("^//(.*)\\\\n");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()) return Optional.of(matcher.group(1));
        else return Optional.empty();
    }
}
