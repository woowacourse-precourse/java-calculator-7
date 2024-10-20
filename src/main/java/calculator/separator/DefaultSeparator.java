package calculator.separator;

import java.util.ArrayList;
import java.util.List;

public class DefaultSeparator implements Separator {
    private final String separator = "[,:]"; //[] 안의 어떤 문자든 일치
    /*
    //()그룹
    \\d 숫자(0-9)
    ()+ 하나 이상 반복
     */
    private final String regex = "(\\d+(" + separator + "))+\\d";

    @Override
    public List<Long> separate(String userInput) {
        if (!userInput.matches(regex)) {
            throw new IllegalArgumentException();
        }
        return separateNumbers(userInput);
    }

    @Override
    public List<Long> separateNumbers(String userInput) {
        String numbers = userInput.replaceAll(separator, "");
        List<Long> nums = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            nums.add(Long.parseLong(String.valueOf(numbers.charAt(i))));
        }
        return nums;
    }
}
