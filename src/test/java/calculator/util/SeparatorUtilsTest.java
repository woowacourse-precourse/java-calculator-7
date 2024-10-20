package calculator.util;

import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SeparatorUtilsTest {

    @BeforeEach
    public void setUp() {
        SeparatorUtils.getSeparators().clear();
        SeparatorUtils.getSeparators().addAll(Set.of(",", ":"));
    }

    @DisplayName("커스텀 구분자로 기본 구분자 설정")
    @Test
    public void testParseSeparatorsWithCustomSeparator() {
        //given
        String input = "//;\\n1;2;3";

        //when
        String remainingExpression = SeparatorUtils.parseSeparators(input);


        //then
        assertThat(remainingExpression).isEqualTo("1;2;3");
        assertThat(SeparatorUtils.getSeparators()).containsExactlyInAnyOrderElementsOf(Set.of(",", ":", ";"));
    }

    @DisplayName("커스텀 구분자 설정")
    @Test
    public void testParseSeparatorsWithMultipleCustomSeparators() {
        //given
        String input = "//as\\n1as2as3";

        //when
        String remainingExpression = SeparatorUtils.parseSeparators(input);

        //then
        assertThat(remainingExpression).isEqualTo("1as2as3");
        assertThat(SeparatorUtils.getSeparators()).containsExactlyInAnyOrderElementsOf(Set.of(",", ":", "a", "s"));
    }

    @DisplayName("기본 구분자 동작 확인")
    @Test
    public void testParseSeparatorsWithDefaultSeparators() {
        //given
        String input = "1,2:3";

        //when
        String remainingExpression = SeparatorUtils.parseSeparators(input);

        //then
        assertThat(remainingExpression).isEqualTo("1,2:3");
        assertThat(SeparatorUtils.getSeparators()).containsExactlyInAnyOrderElementsOf(Set.of(",", ":"));
    }

    @DisplayName("잘못된 형식의 커스텀 구분자")
    @Test
    public void testParseSeparatorsWithInvalidFormat() {
        //given
        String input = "//;";

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> SeparatorUtils.parseSeparators(input));

        //then
        assertThat(exception.getMessage()).isEqualTo("잘못된 입력입니다.");
    }
}
