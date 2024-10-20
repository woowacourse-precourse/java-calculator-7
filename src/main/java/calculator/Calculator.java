package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public int calc(String input) {
        String separators = ",|:";
        String pattern = "^(//.+\\\\n)*([0-9]+(.+[0-9]+)*|)$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);

        if (!m.find()) {
            throw new IllegalArgumentException();
        }

        if (!(m.group(1) == null)) {
            separators = buildSeparators(m.group(1));
        }
        int[] nums = separateNums(m.group(2), separators);

        return sumNums(nums);
    }

    private int[] separateNums(String input, String separators) {
        String[] stringNums = input.split(separators);
        return Arrays.stream(stringNums).mapToInt(this::stringToInt).toArray();
    }

    private String buildSeparators(String customSeparators) {
        String basicSeparators = ",|:";
        customSeparators = customSeparators.replace("\\n", "");
        customSeparators = customSeparators.replace("//", "|");
        return basicSeparators + customSeparators;
    }

    private int stringToInt(String stringNum) {
        if (stringNum.isBlank()) {
            return 0;
        }
        try {
            return Integer.parseInt(stringNum);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private int sumNums(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
