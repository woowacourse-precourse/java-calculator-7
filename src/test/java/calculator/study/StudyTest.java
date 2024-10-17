package calculator.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("처음보는 api 를 학습하는 테스트")
public class StudyTest {

    @DisplayName("Pattern.quote()를 사용하지 않는 경우, 정규표현식 메타문자가 특별한 의미를 가진다")
    @Test
    void test_without_quote_method() {
        String regex = "a*c";
        Pattern pattern = Pattern.compile(regex);

        assertThat(pattern.matcher("aaaac").matches()).isTrue();
        assertThat(pattern.matcher("ac").matches()).isTrue();

        assertThat(pattern.matcher("a*c").matches()).isFalse();
    }

    @DisplayName("Pattern.quote()를 사용하는 경우, 모든 문자가 리터럴로 취급된다")
    @Test
    void test_with_quote_method() {
        String regex = Pattern.quote("a*c");
        Pattern pattern = Pattern.compile(regex);

        assertThat(pattern.matcher("aaaac").matches()).isFalse();
        assertThat(pattern.matcher("ac").matches()).isFalse();

        assertThat(pattern.matcher("a*c").matches()).isTrue();
    }
}
