package calculator.model.separate;

import calculator.common.message.ErrorMessage;
import calculator.model.exception.MultiCustomDelimiterException;
import calculator.model.exception.NotAllowedPositionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Nested
public class SeparateManagerTest {

    @Nested
    class parseCustomDelimiter {

        @Test
        @DisplayName("* - custom delimiter")
        void singleCustomDelimiterTest1() {
            // given
            String expected = "*";
            String source = "//*\n1*2*3*4*";
            SeparateManager manager = SeparateManager.initiate();
            // when
            String actual = manager.parseCustomDelimiter(source);
            // then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("*& - custom delimiter")
        void singleCustomDelimiterTest2() {
            // given
            String expected = "*&";
            String source = "//*&\n1*&2*&3*&4*&";
            SeparateManager manager = SeparateManager.initiate();
            // when
            String actual = manager.parseCustomDelimiter(source);
            // then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("[MultiCustomDelimiterException] - custom delimiter 2개 이상인 경우")
        void moreThanOneCustomDelimiters() {
            // given
            String source = "//*&\n1//$\n*&2:3,4*&";
            SeparateManager manager = SeparateManager.initiate();
            // when
            // then
            assertThatThrownBy(() -> manager.parseCustomDelimiter(source))
                    .isInstanceOf(MultiCustomDelimiterException.class)
                    .hasMessage(ErrorMessage.MULTI_DELIMITER);
        }

        @Test
        @DisplayName("[NotAllowedPositionException] - custom-delimiter checker 위치가 문자열 맨 앞이 아닌 경우")
        void notAllowedCheckerPosition() {
            // given
            String source = "1$3$//$\n*&2:3,4&";
            SeparateManager manager = SeparateManager.initiate();
            // when
            // then
            assertThatThrownBy(() -> manager.parseCustomDelimiter(source))
                    .isInstanceOf(NotAllowedPositionException.class)
                    .hasMessage(ErrorMessage.CHECKER_POSITION);
        }
    }
}
