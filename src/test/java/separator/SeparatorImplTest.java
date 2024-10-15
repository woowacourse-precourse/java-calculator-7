package separator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class SeparatorImplTest {
    private static Separator separator = new SeparatorImpl();

    @BeforeEach
    void setUp() {
        separator = new SeparatorImpl();
    }

    @Test
    @DisplayName("기본 구분자 확인")
    void 기본_구분자() {
        // given
        String input = "test_separator";
        // when
        separator.addSeparator(input);
        Collection<String> separators = separator.getAllSeparator();
        // then
        assertThat(separators).contains(",").contains(":");
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
        String alreadyExistSeparator = ":";
        // when
        separator.addSeparator(alreadyExistSeparator);
        Collection<String> separators = separator.getAllSeparator();
        // then
        assertThat(separators).hasSize(2);
    }

}
