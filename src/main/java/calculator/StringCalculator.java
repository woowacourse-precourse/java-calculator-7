package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 문자열을 구분자로 분리하여 다양한 계산을 하는 문자열 계산기다.
 */
public class StringCalculator {
    private final String userInput; // 사용자가 입력한 문자열
    private String delimiter; // 정규표현식 형태의 구분자
    private String string; // (커스텀 구분자 양식을 제외한) 분리되지 않은 문자열
    private String[] substrings; // 구분자로 분리된 문자열

    /**
     * 문자열을 받아 분리해서 필드를 초기화한다.
     *
     * @param userInput 사용자가 입력한 문자열
     */
    public StringCalculator(String userInput) {
        this.userInput = userInput;
        this.delimiter = "[,:]"; // 기본 구분자
        this.string = userInput;

        allowCustomDelimiter("//", "\\n");
        this.substrings = string.split(delimiter);
    }

    /**
     * 커스텀 구분자 양식이 발견되면 delimiter 와 string 필드를 업데이트한다.
     * 문자열 앞부분의 from 과 to 사이에 위치하는 문자열을 커스텀 구분자로 사용한다.
     */
    private void allowCustomDelimiter(String from, String to) {
        String regex = String.format("(^%s)(.+?)(%s)(.*)", Pattern.quote(from), Pattern.quote(to));
        Matcher matcher = Pattern.compile(regex).matcher(string);
        if (matcher.find()) {
            delimiter = Pattern.quote(matcher.group(2));
            string = matcher.group(4);
        }
    }

    /**
     * 분리된 문자열에서 추출한 수의 합을 반환한다.
     * 분리된 문자열이 양의 정수 형태가 아니면,
     * IllegalArgumentException 을 발생시킨다.
     */
    public int getSum() {
        int sum = 0;

        for (String substring : substrings) {
            if (!substring.matches("^[0-9]*$") || substring.matches("^0+$")) {
                throw new IllegalArgumentException(substring + " is not a positive integer.");
            }
            if (!substring.isEmpty()) {
                sum += Integer.parseInt(substring);
            }
        }

        return sum;
    }
}
