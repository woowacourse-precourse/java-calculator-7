package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    public static final String DEFAULT_DELIMITER_REGEX = "^([1-9]\\d*)((,|:)([1-9]\\d*))*$";
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\\\\n(.+)";
    public static final int ZERO = 0;
    public static final int CUSTOM_DELIMITER_GROUP = 1;
    public static final int INPUT_NUM_GROUP = 2;
    public static final String COMMA_DELIMITER = ",";
    public static final String COLON_DELIMITER = ":";
    public static final String SPACE = " ";

    public List<Integer> checkAndParseInput(String input) throws IllegalArgumentException{
        if (input.isEmpty()) {
            return List.of(ZERO,ZERO);
        }
        if (checkDefaultDelimiter(input)) {
            return convertDefaultDelimiter(input);
        }
        return convertCustomDelimiter(input);
    }

    protected boolean checkDefaultDelimiter(String input) {
        return input.matches(DEFAULT_DELIMITER_REGEX);
    }

    protected List<Integer> convertDefaultDelimiter(String input) throws IllegalArgumentException {
        try {
            input = input.replace(COMMA_DELIMITER, SPACE).replace(COLON_DELIMITER , SPACE);
            String[] inputs = input.split(SPACE);
            return convertToIntList(inputs);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    protected List<Integer> convertCustomDelimiter(String input) throws IllegalArgumentException{
        try {
            Pattern p = Pattern.compile(CUSTOM_DELIMITER_REGEX);
            Matcher matcher = p.matcher(input);
            if(matcher.matches()) {
                String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
                String inputNum = matcher.group(INPUT_NUM_GROUP);
                List<Integer> list = splitAndConvert(customDelimiter, inputNum);
                checkPositiveNumber(list);
                return list;
            }
            throw new IllegalArgumentException();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> splitAndConvert(String customDelimiter, String inputNum) {
        String[] split = inputNum.split(customDelimiter);
        List<Integer> list = convertToIntList(split);
        return list;
    }

    private static List<Integer> convertToIntList(String[] split) {
        return Arrays.stream(split)
            .map(Integer::parseInt)
            .toList();
    }

    protected void checkPositiveNumber(List<Integer> list) throws IllegalArgumentException{
        for (Integer integer : list) {
            if (integer <= 0) {
                throw new IllegalArgumentException();
            }
        }
    }
}
