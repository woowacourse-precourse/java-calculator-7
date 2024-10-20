package calculator.string;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegexUtil {

    private static final String CUSTOM_DELIM_PATTERN = "//(.*)\\\\n(.*)";

    // 확장 가능한 메서드로 설계
    /** 요소들 통해서 정규식을 만들어주는 메서드
     * @param elems 정규식을 구성할 요소들
     * @return 정규식
     */
    public String createRegex(String... elems) {
        return Arrays.stream(elems)
                .map(elem -> Pattern.quote(elem))
                .collect(Collectors.joining("|"));
    }

    /** 문자열에서 커스텀 구분자를 추출
     * @param str 커스텀 구분자를 추출할 문자열
     * @return 파싱된 구분자, 없으면 Null
     */
    public String parseCustomDelimiter(String str) {
        Matcher matcher = parse(str);

        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    /** 문자열에서 커스텀 구분자 제거 후 문자열 반환
     * @param str 커스텀 구분자를 제거 할 문자열
     * @return 커스텀 구분자 제거된 문자열
     */
    public String removeCustomDelimiter(String str) {
        Matcher matcher = parse(str);

        if (matcher.find()) {
            return matcher.group(2);
        }
        return str;
    }

    /** 중복된 코드 제거를 위한 헬퍼 메서드
     * @param str
     * @return Matcher 객체
     */
    private Matcher parse(String str) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIM_PATTERN);
        return pattern.matcher(str);
    }

}

