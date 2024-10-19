package calculator;

import java.util.ArrayList;
import java.util.List;

public class DefaultSeparator extends AbstractSeparator {
    private final String separator = "[,:]";
    private final String regex = "(\\d+(separator))+\\d";


    @Override
    public List<Long> separate(String userInput) {
        if (!userInput.matches(regex)) {
            throw new IllegalArgumentException();
        }
        return separateNumbers(userInput);
    }

    @Override
    public List<Long> separateNumbers(String userInput) {
        String numbers = userInput.replaceAll(regex, "");
        List<Long> nums = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            nums.add(Long.parseLong(String.valueOf(numbers.charAt(i))));
        }
        return nums;
    }
}
