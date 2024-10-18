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

    public List<Integer> extract(String text) {
        List<String> extractList = new ArrayList<>(separatorExtract(text));
        extractList = checkListSize(extractList);
        if (!extractList.isEmpty()) {
            validExtractList(extractList);
        }
        return extractList.stream()
                .map(Integer::parseInt).collect(Collectors.toList());
    }

    private List<String> checkListSize(List<String> list){
        return list.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    private List<String> separatorExtract(String text){
        if(text.startsWith("//")){
            return List.of(customSeparatorExtract(text));
        }
        return List.of(basicSeparatorExtract(text));
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
