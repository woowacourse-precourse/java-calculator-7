package calculator.controller;

import calculator.input.InputValidator;
import calculator.staticValue.RegexPatterns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    private static final InputValidator inputValidator = new InputValidator();


    public String[] SplitInputBySeparators(String input) {
        Map<List<String>, String> separatorsAndString = parseCustomSeparators(input);

        List<String> Separators = separatorsAndString.keySet().iterator().next();
        String beforeCaculateString = separatorsAndString.values().stream().findFirst().orElse("");

        String separatorsRegex = Separators.stream().map(Pattern::quote).reduce((a, b) -> a + "|" + b).orElse("");

        String customAndBasicSeparatorsRegex = separatorsRegex + "|" + RegexPatterns.BASIC_SEPARATORS.getValue();
        return beforeCaculateString.split(customAndBasicSeparatorsRegex);
    }

    private static Map<List<String>, String> parseCustomSeparators(String input) {
        List<String> customizedSeparators = new ArrayList<>();
        String updatedInputString = removeSeparatorDeclarationRecursively(input, customizedSeparators);

        return mapSeparatorsToString(customizedSeparators, updatedInputString);
    }

    private static String removeSeparatorDeclarationRecursively(String input, List<String> separators) {
        try {
            String customizedSeparator = extractCustomSeparator(input);
            separators.add(customizedSeparator);

            String updatedInputString = removeCustomSeparatorDeclaration(input, customizedSeparator);
            System.out.println("구분자: " + customizedSeparator);
            System.out.println("구분자가 삭제된 문자열: " + updatedInputString);

            return removeSeparatorDeclarationRecursively(updatedInputString, separators);
        } catch (IllegalArgumentException e) {
            return input;
        }
    }

    private static Map<List<String>, String> mapSeparatorsToString(List<String> customizedSeparators,
                                                                   String processedInputString) {
        Map<List<String>, String> SeparatorAndString = new HashMap<>();
        SeparatorAndString.put(customizedSeparators, processedInputString);
        return SeparatorAndString;
    }

    private static String extractCustomSeparator(String input) {
        Matcher matcher = inputValidator.findCustomizedSeparator(input);
        return matcher.group(1);
    }

    private static String removeCustomSeparatorDeclaration(String input, String customizedSeparator) {
        return input.replaceAll(
                RegexPatterns.CUSTOM_SEPARATOR_PREFIX.getValue()
                        + Pattern.quote(customizedSeparator)
                        + RegexPatterns.CUSTOM_SEPARATOR_SUFFIX.getValue(), "");
    }


    public int calculateSum(String[] splitInputNumbers) {
        int sum = 0;
        for (String number : splitInputNumbers) {
            if (inputValidator.isInputEmpty(number)) {
                return 0;
            }
            sum += Integer.parseInt(number);
        }
        return sum;
    }


}