package separator;

import calculator.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class SeparatorTest {
    private static Separator separator;

    @BeforeEach
    void setUp() {
        separator = new AppConfig().separator();
    }

    @Test
    @DisplayName("구분자 추가")
    void 구분자_추가() {
        // given
        String input = "test_separator";
        // when
        separator.addSeparator(input);
        Collection<String> separators = separator.getAllSeparator();
        // then
        assertThat(separators).contains(input);
    }

    @Test
    @DisplayName("중복된 구분자를 추가하는 경우, 무시")
    void 구분자_중복_추가() {
        // given
        String separator1 = "test_separator";
        separator.addSeparator(separator1);
        Collection<String> separators = separator.getAllSeparator();
        int beforeSize = separators.size();

        // when
        separator.addSeparator(separator1);
        separators = separator.getAllSeparator();
        int afterSize = separators.size();

        // then
        assertThat(beforeSize).isEqualTo(afterSize);
    }

    @Test
    @DisplayName("빈 문자열 구분자를 추가하는 경우, 무시")
    void 빈_문자열_구분자_추가() {
        // given
        String emptySeparator = "";
        // when
        separator.addSeparator(emptySeparator);
        Collection<String> separators = separator.getAllSeparator();
        // then
        assertThat(separators).doesNotContain("");
    }

    @Test
    @DisplayName("null 구분자를 추가하는 경우, 무시")
    void null_구분자_추가() {
        // given
        String nullSeparator = null;
        // when
        separator.addSeparator(nullSeparator);
        Collection<String> separators = separator.getAllSeparator();
        // then
        assertThat(separators).doesNotContain((String) null);
    }
}
