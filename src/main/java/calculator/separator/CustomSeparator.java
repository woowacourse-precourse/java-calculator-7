package calculator.separator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparator implements Separator {
    private String separator = "";
    private final String customPrefix = "//";
    private final String customSuffix = "\\n";
    private final String regex = "//([^0-9])\\\\n((\\d+\\1)*\\d+)";

    @Override
    public List<Long> separate(String userInput) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
        this.separator = matcher.group(1);

        return separateNumbers(matcher.group(2));
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
