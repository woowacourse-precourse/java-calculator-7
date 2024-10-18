package calculator.service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 구분자를 찾아내서 return에 숫자만 넘겨주기
public class SeparatorCheck {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    public String[] split(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        // 사용자 지정 구분자가 있을 경우
        if (matcher.find()) {
            String customDelimiter = matcher.group(1); // 사용자가 지정한 구분자
            String nums = matcher.group(2).replace("\"", ""); // 구분자 정의 뒷 부분

            String finalDelimiter = customDelimiter + "|" + DEFAULT_DELIMITER;
            System.out.println(finalDelimiter);
            System.out.println(Arrays.toString(nums.split(finalDelimiter)));

//            return numbers.split(combinedDelimiter); // 커스텀 구분자로 분리
            return nums.split(finalDelimiter);
        } else{
            System.out.println("There is no user-specified delimiter.");
        }
        return input.split(DEFAULT_DELIMITER);
    }
}
