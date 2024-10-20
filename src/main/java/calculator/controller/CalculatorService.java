package calculator.controller;

import calculator.input.Input;
import calculator.staticValue.StaticValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    private static final Input input = new Input();


    public String[] SplitStringUsingSeparators(String inputString) {
        Map<List<String>, String> separatorsAndString = findSeparatorsAndRemove(inputString);

        List<String> Separators = separatorsAndString.keySet().iterator().next();
        //String beforeCaculateString = separatorsAndString.values().iterator().next();
        String beforeCaculateString = separatorsAndString.values().stream().findFirst().orElse("");

        String separatorsRegex = Separators.stream().map(Pattern::quote).reduce((a, b) -> a + "|" + b).orElse("");

        String customAndBasicSeparatorsRegex = separatorsRegex + "|" + StaticValue.BASIC_SEPARATORS_REGEX.getValue();
        return beforeCaculateString.split(customAndBasicSeparatorsRegex);
    }

    private static Map<List<String>, String> findSeparatorsAndRemove(String inputString) {
        List<String> customizedSeparators = new ArrayList<>();
        String updatedInputString = processSeparators(inputString, customizedSeparators);

        return createSeparatorAndStringMap(customizedSeparators, updatedInputString);
    }

    private static String processSeparators(String inputString, List<String> separators) { // 여기 이름 수정
        try {
            String customizedSeparator = extractCustomizedSeparator(inputString);
            separators.add(customizedSeparator);

            String updatedInputString = generateStringOfRemovingCustom(inputString, customizedSeparator);
            System.out.println("구분자: " + customizedSeparator);
            System.out.println("구분자가 삭제된 문자열: " + updatedInputString);

            return processSeparators(updatedInputString, separators);
        } catch (IllegalArgumentException e) {
            return inputString;
        }
    }

    private static Map<List<String>, String> createSeparatorAndStringMap(List<String> customizedSeparators,
                                                                         String updatedInputString) {
        Map<List<String>, String> SeparatorAndString = new HashMap<>();
        SeparatorAndString.put(customizedSeparators, updatedInputString);
        return SeparatorAndString;
    }

    private static String extractCustomizedSeparator(String inputString) {
        Matcher matcher = input.findCustomizedSeparator(inputString);
        return matcher.group(1);
    }

    private static String generateStringOfRemovingCustom(String inputString, String customizedSeparator) {
        return inputString.replaceAll(
                StaticValue.CUSTOM_SEPARATOR_PREFIX.getValue()
                        + Pattern.quote(customizedSeparator)
                        + StaticValue.CUSTOM_SEPARATOR_SUFFIX.getValue(), "");
    }


    public int calculateSum(String[] inputNumberString) {
        int sum = 0;
        for (String s : inputNumberString) {
            if (input.hasEmptyInput(s)) {
                return 0;
            }
            sum += Integer.parseInt(s);
        }
        return sum;
    }


}