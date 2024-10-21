package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 문자열에서 숫자를 추출해 합계를 계산하는 클래스입니다. 기본 구분자(쉼표, 콜론)와 커스텀 구분자를 지원합니다.
 */
public class Calculator {

    private String findCustomSeparator(String str) {

        Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
        Matcher matcher = pattern.matcher(str);

        if (matcher.matches()) {
            return matcher.group(1);  // 첫 번째 그룹은 구분자
        }

        return null;
    }

    private int parseAndValidate(String num) {

        if (!num.matches("\\d+")) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: ");
        }

        return Integer.parseInt(num);
    }

    /**
     * 주어진 문자열에서 구분자로 나뉜 숫자의 합을 계산합니다.
     *
     * @param str 입력 문자열 (쉼표, 콜론 또는 커스텀 구분자 사용)
     * @return 문자열에 포함된 숫자의 합
     */
    public int sum(String str) {

        if (str == null) {
            return 0;
        }

        String custom = findCustomSeparator(str);
        String separatorRegex = ",|:";

        if (custom != null) {
            separatorRegex += "|" + custom;
            str = str.substring(5);
        }

        if (str.isEmpty()) {
            return 0;
        }

        String[] nums = str.split(separatorRegex);
        int sum = 0;

        for (String num : nums) {
            sum += parseAndValidate(num);
        }

        return sum;
    }
}
