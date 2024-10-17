package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.regex.Matcher;

import static org.assertj.core.api.Assertions.assertThat;

class CustomRegexMatcherTest {

    @DisplayName("계산식이 커스텀 구분자를 포함하는지 테스트하라 (단, Java 에서는 백슬래쉬와 n만 쓰면 이스케이프처리가 되므로 주의해야함)")
    @ParameterizedTest(name = "[{index}] {arguments}")
    @CsvSource(useHeadersInDisplayName = true, textBlock = """
            NUMBER_STRING, EXPECTED
            1;2;3,         false
            ;1;2;3,        false
            /;1;2;3,       false
            //;1;2;3,      false
            //\\n1;2;3,    false
            //;\\n1;2;3,   true
            //*\\n1*2*3,   true
            //~\\n1~1~3,   true
    """)
    void test_numbersString_is_match_with_custom_regex(String numbersString, boolean expected) {
        Matcher matcher = CustomRegexMatcher.getMatcher(numbersString);

        boolean isMatch = matcher.find();

        assertThat(isMatch).isEqualTo(expected);
    }
}
