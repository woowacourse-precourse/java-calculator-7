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

    public int parseAndValidate(String num) {

        if (!num.matches("\\d+")) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: ");
        }

        return Integer.parseInt(num);
    }

    public int sum(String str) {

        if (str == null || str.isEmpty()) {
            return 0;
        }

        String custom = findCustomSeparator(str);
        String separatorRegex = ",|:";

        if (custom != null) {
            separatorRegex += "|" + custom;
            str = str.substring(5);
        }

        String[] nums = str.split(separatorRegex);
        int sum = 0;

        for (String num : nums) {
            sum += parseAndValidate(num);
        }

        return sum;
    }
}
