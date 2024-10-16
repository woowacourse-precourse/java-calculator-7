package calculator.number;

import calculator.validation.SeparatorValidation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Division {

    private static final String DEFAULT_SEPARATOR = ",|:";

    public static List<String> getStringList(String input){
        SeparatorValidation.separator(input); // 구분자가 있는지 검사
        return getList(input);
    }

    private static List<String> getList(String input) {
        List<String> list = new ArrayList<>();
        if (isDefaultSeparator(input)) {
            return makeList(input, DEFAULT_SEPARATOR, list);
        }
        // 커스텀 구분자를 사용했을 경우
        String patten = getPatten(input);
        input = input.substring(input.indexOf("\\n") + 2);
        return makeList(input, patten, list);
    }

    private static boolean isDefaultSeparator(String input) {
        return !input.contains("//") && !input.contains("\\n");
    }

    private static String getPatten(String input) {
        StringBuilder customPatten = new StringBuilder();
        String customSeparator = input.substring(input.indexOf("//") + 2, input.indexOf("\\n"));
        String[] separators = customSeparator.split("");
        for (String separator : separators) {
            customPatten.append("\\").append(separator).append("|");
        }
        return customPatten  + DEFAULT_SEPARATOR;
    }

    private static List<String> makeList(String input, String patten, List<String> list) {
        String[] inputStrings = input.split(patten);
        Collections.addAll(list, inputStrings);
        return list;
    }
}
