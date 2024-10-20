package calculator.domain;

import calculator.validation.NumberValidation;
import calculator.validation.SeparatorValidation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Division {

    private static final String DEFAULT_SEPARATOR = ",|:";

    public static List<Integer> createNumberList(String input){
        SeparatorValidation.separator(input);

        if (input.isBlank()) {
            return Collections.emptyList();
        }

        return generateList(input);
    }

    private static List<Integer> generateList(String input) {
        List<Integer> list = new ArrayList<>();

        if (isDefaultSeparator(input)) {
            return createList(input, DEFAULT_SEPARATOR, list);
        }
        // 커스텀 구분자를 사용했을 경우
        String patten = createPattern(input);
        input = input.substring(input.indexOf("\\n") + 2);
        return createList(input, patten, list);
    }

    private static boolean isDefaultSeparator(String input) {
        return !input.contains("//") && !input.contains("\\n");
    }

    private static String createPattern(String input) {
        List<String> customPattern = CustomPatternMaker.createCustomPattern(input);
        String pattern = String.join("|", customPattern);
        return pattern + "|" + DEFAULT_SEPARATOR;
    }

    private static List<Integer> createList(String input, String patten, List<Integer> list) {
        String[] inputStrings = input.split(patten);
        for (String inputString : inputStrings) {
            inputString = inputString.trim(); // 입력에 공백이 있을 수 있으므로 제거해준다.
            numberValidation(inputString);
            list.add(Integer.parseInt(inputString));
        }
        return list;
    }

    private static void numberValidation(String input) {
        NumberValidation.validation(input);
    }
}
