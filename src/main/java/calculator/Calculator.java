package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public String findCustomSeparator(String str) {

        Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
        Matcher matcher = pattern.matcher(str);

        if (matcher.matches()) {
            return matcher.group(1);  // 첫 번째 그룹은 구분자
        }

        return null;
    }

    public int parseAndValidate(String s) {

        if (!s.matches("\\d+")) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: " + s);
        }

        int number = Integer.parseInt(s);

        return number;
    }

    public int sum(String str) {

        if (str == null || str.isEmpty()) {
            return 0;
        }

        String custom = findCustomSeparator(str);
        String regex = ",|:";

        if (custom != null) {
            regex += "|" + custom;
            str = str.substring(5);
        }

        String[] nums = str.split(regex);
        int sum = 0;

        for (String s : nums) {
            sum += parseAndValidate(s);
        }

        return sum;
    }
}
