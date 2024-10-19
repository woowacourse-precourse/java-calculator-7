package calculator.calculator;

import calculator.Validator;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomCalculator {

    private static final String META_CHARS = "*+?$^.()|\\{}[";

    public int calculate(String inputString) {
        String targetString = getTargetString(inputString);
        if (isTargetStringEmpty(targetString)) {
            return 0;
        }
        String splitRegex = getSplitRegex(inputString);
        String[] elements = targetString.split(splitRegex);
        int[] intArray = Validator.validateToIntArray(elements);
        Validator.checkHasNotPositive(intArray);
        return Arrays.stream(intArray).sum();
    }

    private String getTargetString(String inputString) {
        Pattern pattern = Pattern.compile("(?<=\\\\n)(.*)", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    private boolean isTargetStringEmpty(String targetString) {
        return targetString.isEmpty();
    }

    private String getSplitRegex(String inputString) {
        Pattern pattern = Pattern.compile("//(.*)\\\\n", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.find()) {
            String delimiterString = matcher.group(1);
            String convertedDelimiterString = convertDelimiterString(delimiterString);
            return "[" + convertedDelimiterString + "]";
        }
        throw new IllegalArgumentException("구분자를 찾을 수 없습니다.");
    }

    private String convertDelimiterString(String delimiterString) {
        return delimiterString.chars()
                .mapToObj(c -> getDelimiter((char) c))
                .collect(Collectors.joining());
    }

    private String getDelimiter(Character delimiter) {
        if (delimiter.equals('\\')) {
            return "\\\\";
        }
        if (isMetaCharacter(delimiter)) {
            return "\\" + delimiter;
        }
        return Character.toString(delimiter);
    }

    private boolean isMetaCharacter(Character separator) {
        return META_CHARS.indexOf(separator) != -1;
    }


}
