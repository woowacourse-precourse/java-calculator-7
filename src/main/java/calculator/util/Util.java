package calculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static calculator.util.Validator.validCustomSeparator;
import static calculator.util.Validator.validExtractList;


public class Util {
    private static final String BASIC_SEPARATOR = "[,:]";
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\\\\n(.*)";

    public List<Integer> extract(String text){
        String[] extractList = separatorExtract(text);
        validExtractList(extractList);
        return Arrays.stream(extractList).map(Integer::parseInt).collect(Collectors.toList());
    }
    private String[] separatorExtract(String text){
        if(text.startsWith("//")){
            return customSeparatorExtract(text);
        }
        return basicSeparatorExtract(text);
    }

    private String[] basicSeparatorExtract(String text){
        return text.split(BASIC_SEPARATOR);
    }

    private String[] customSeparatorExtract(String text){
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
