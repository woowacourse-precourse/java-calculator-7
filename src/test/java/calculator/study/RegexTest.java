package calculator.study;

import calculator.constant.Constants.Regex;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegexTest {

    @Test
    public void 커스텀구분자_정규표현식_테스트() {
        // given
        String input = "//;\\n1;2;3";
        Matcher matcher = getMatcher(input);

        // when & then
        Assertions.assertThat(haveCustomSeparator(matcher)).isTrue();
    }

    @Test
    public void 커스텀구분자_정규표현식_두번째그룹_추출_테스트() {
        // given
        String input = "//;\\n1";
        Matcher matcher = getMatcher(input);

        // when & then
        Assertions.assertThat(haveCustomSeparator(matcher)).isTrue();
        Assertions.assertThat(matcher.group(2)).isEqualTo("1");
    }

    private Matcher getMatcher(String input) {
        return Pattern.compile(Regex.CUSTOM_SEPARATOR_FORMAT_REGEX)
                .matcher(input);
    }

    private boolean haveCustomSeparator(Matcher matcher) {
        return matcher.matches();
    }

}
