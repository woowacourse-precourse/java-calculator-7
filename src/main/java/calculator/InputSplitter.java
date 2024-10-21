package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputSplitter {
    private static final String REGEX = "//.*\\\\n";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(REGEX);

    public static int[] split(String s){

        if(s.startsWith("/"))
            return splitIntoOperandsWithCustomDelimiter(s);

        return splitIntoOperands(s);
    }

    private static int[] splitIntoOperands(String input){

        String[] segments = input.split("[,|;]");

        if(doesNotHaveAnyNumber(segments))
            return new int[]{0};

        return convertOperandsIntoNumber(segments);
    }

    private static int[] splitIntoOperandsWithCustomDelimiter(String input){

        String matchingPart = findMatchingPart(input);

        String delimiter = extractDelimiterFrom(matchingPart);

        int startIndex = matchingPart.length();
        String numberString = detachDelimiterFrom(input, startIndex);

        String[] segments = numberString.split(delimiter);

        if(doesNotHaveAnyNumber(segments))
            return new int[]{0};

        return convertOperandsIntoNumber(segments);
    }

    private static int[] convertOperandsIntoNumber(String[] segments) {

        List<Integer> numberList = new ArrayList<>();

        for(int i = 0; i < segments.length; i++) {

            if(segments[i].isEmpty())
                continue;

            try {
                numberList.add(Integer.parseInt(segments[i]));
            }catch (Exception e){
                throw new IllegalArgumentException();
            }

        }

        int[] result = new int[numberList.size()];

        for(int i = 0; i < result.length; i++)
            result[i] = numberList.get(i);

        return result;
    }

    private static String extractDelimiterFrom(String matchingPart) {
        return matchingPart.substring(2, matchingPart.length() - 2);
    }

    private static String detachDelimiterFrom(String s, int startIndex){
        return s.substring(startIndex);
    }

    private static String findMatchingPart(String input) {
        Matcher matchingResult = CUSTOM_DELIMITER_PATTERN.matcher(input);
        matchingResult.find();
        return matchingResult.group();
    }

    private static boolean doesNotHaveAnyNumber(String[] operands) {
        return operands.length == 1 && "".equals(operands[0]);
    }
}
