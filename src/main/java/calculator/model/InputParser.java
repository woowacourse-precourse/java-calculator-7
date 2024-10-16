package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    public List<Integer> checkAndParseInput(String input) throws IllegalArgumentException{
        if (input.isEmpty()) {
            return List.of(0,0);
        }
        if (checkDefaultDelimiter(input)) {
            return convertDefaultDelimiter(input);
        }
        return convertCustomDelimiter(input);
    }

    protected boolean checkDefaultDelimiter(String input) {
        String defaultDelimiterRegex = "^([1-9]\\d*)((,|:)([1-9]\\d*))*$";
        return input.matches(defaultDelimiterRegex);
    }

    protected List<Integer> convertDefaultDelimiter(String input) throws IllegalArgumentException {
        try {
            input = input.replace(","," ").replace(":"," ");
            String[] inputs = input.split(" ");
            return convertToIntList(inputs);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    protected List<Integer> convertCustomDelimiter(String input) throws IllegalArgumentException{
        try {
            String customDelimiterRegex = "//(.)\\\\n(.+)";
            Pattern p = Pattern.compile(customDelimiterRegex);
            Matcher matcher = p.matcher(input);
            if(matcher.matches()) {
                String customDelimiter = matcher.group(1);
                String inputNum = matcher.group(2);
                String[] split = inputNum.split(customDelimiter);
                List<Integer> list = convertToIntList(split);
                checkPositiveNumber(list);
                return list;
            }
            throw new IllegalArgumentException();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
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
