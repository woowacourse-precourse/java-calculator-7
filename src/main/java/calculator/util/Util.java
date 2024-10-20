package calculator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static calculator.util.Validator.validCustomSeparator;
import static calculator.util.Validator.validExtractList;


public class Util {
    private static final String BASIC_SEPARATOR = "[,:]";
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\\\\n(.*)";

    public List<Integer> extractNumbers(String text) {
        List<String> extractList = new ArrayList<>(extractBasedOnSeparator(text));
        extractList = getNonEmptyStrings(extractList);
        if (!extractList.isEmpty()) {
            validExtractList(extractList);
        }
        return extractList.stream()
                .map(Integer::parseInt).collect(Collectors.toList());
    }

    private List<String> getNonEmptyStrings(List<String> list){
        return list.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    private List<String> extractBasedOnSeparator(String text){
        if(text.startsWith("//")){
            return List.of(splitByCustomSeparator(text));
        }
        return List.of(splitByBasicSeparator(text));
    }

    private String[] splitByBasicSeparator(String text){
        return text.split(BASIC_SEPARATOR);
    }

    private String[] splitByCustomSeparator(String text){
        validCustomSeparator(text);
        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(text);
        if (matcher.matches()) {
            String customSeparator = matcher.group(1);
            String customInput = matcher.group(2);
            return customInput.split(Pattern.quote(customSeparator));
        }
        throw new IllegalArgumentException();
    }

}
