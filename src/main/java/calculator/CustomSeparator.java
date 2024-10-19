package calculator;

import java.util.ArrayList;
import java.util.List;

public class CustomSeparator extends AbstractSeparator {
    private String separator = "";
    private final String customPrefix = "//";
    private final String customSuffix = "\\n";
    private final String regex = "(\\d+(separator))+\\d";

    @Override
    public List<Long> separate(String userInput) {
        int pIndex = userInput.indexOf(customPrefix);
        int sIndex = userInput.indexOf(customSuffix);
        if (sIndex == -1 || pIndex == -1) {
            throw new IllegalArgumentException();
        }
        this.separator = userInput.substring(pIndex + customPrefix.length(), sIndex);

        return separateNumbers(userInput.substring(sIndex + customSuffix.length()));
    }

    @Override
    public List<Long> separateNumbers(String userInput) {
        String numbers = userInput.replace(separator, "");
        List<Long> nums = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            nums.add(Long.parseLong(String.valueOf(numbers.charAt(i))));
        }
        return nums;
    }
}
