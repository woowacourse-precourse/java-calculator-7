package calculator.string;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegexUtil {

    // 확장 가능한 메서드로 설계
    /** 요소들 통해서 정규식을 만들어주는 메서드
     * @param elems 정규식을 구성할 요소들
     * @return 정규식
     */
    public String createRegex(String... elems) {
        String regex = Arrays.stream(elems)
                .map(elem -> Pattern.quote(elem))
                .collect(Collectors.joining("|"));

        return regex;
    }

}
