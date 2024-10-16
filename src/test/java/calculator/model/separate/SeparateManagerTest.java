package calculator.model.separate;

import calculator.common.message.ErrorMessage;
import calculator.model.exception.MultiCustomDelimiterException;
import calculator.model.exception.NotAllowedPositionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Nested
public class SeparateManagerTest {

    @Nested
    class ParseCustomDelimiterTest {

        @Test
        @DisplayName("* - custom delimiter")
        void singleCustomDelimiterTest1() {
            // given
            String expected = "*";
            String source = "//*\\n1*2*3*4*";
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
            String source = "//*&\\n1*&2*&3*&4*&";
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
            String source = "//*&\\n1//$\\n*&2:3,4*&";
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
            String source = "1$3$//$\\n*&2:3,4&";
            SeparateManager manager = SeparateManager.initiate();
            // when
            // then
            assertThatThrownBy(() -> manager.parseCustomDelimiter(source))
                    .isInstanceOf(NotAllowedPositionException.class)
                    .hasMessage(ErrorMessage.CHECKER_POSITION);
        }
    }

    @Nested
    class SingleCustomDelimiterTest {

        @Test
        @DisplayName("커스텀 딜리미터 *가 있는 경우")
        void onlyCustomDelimiterTest1() {
            // given
            String source = "//*\\n1*2*3*4*";
            SeparateManager manager = SeparateManager.initiate();
            manager.extractCustomDelimiter(source);
            // when
            List<Integer> actual = manager.split(source);
            // then
            assertThat(actual.size()).isEqualTo(4);
        }

        @Test
        @DisplayName("커스텀 딜리미터 백슬래쉬(\\)2개가 있는 경우")
        void onlyCustomDelimiterTest2() {
            // given
            String source = "//\\\\\\n\\\\1\\\\2\\\\3\\\\4";
            SeparateManager manager = SeparateManager.initiate();
            manager.extractCustomDelimiter(source);
            // when
            List<Integer> actual = manager.split(source);
            // then
            assertThat(actual.size()).isEqualTo(4);
        }

        @Test
        @DisplayName("커스텀 딜리미터 //가 있는 경우")
        void onlyCustomDelimiterTest3() {
            // given
            String source = "////\\n1//2//3//4";
            SeparateManager manager = SeparateManager.initiate();
            manager.extractCustomDelimiter(source);
            // when
            List<Integer> actual = manager.split(source);
            // then
            assertThat(actual.size()).isEqualTo(4);
        }

        @Test
        @DisplayName("커스텀 딜리미터 ////가 있는 경우")
        void onlyCustomDelimiterTest4() {
            // given
            String source = "//////\\n1////2////3////4";
            SeparateManager manager = SeparateManager.initiate();
            manager.extractCustomDelimiter(source);
            // when
            List<Integer> actual = manager.split(source);
            // then
            assertThat(actual.size()).isEqualTo(4);
        }

        @Test
        @DisplayName("커스텀 딜리미터 영어 n이 있는 경우")
        void onlyCustomDelimiterTest6() {
            // given
            String source = "//n\\n1n2n3n4n";
            SeparateManager manager = SeparateManager.initiate();
            manager.extractCustomDelimiter(source);
            // when
            List<Integer> actual = manager.split(source);
            // then
            assertThat(actual.size()).isEqualTo(4);
        }
    }

    @Nested
    class ComplexDelimiterTest {

        @Test
        @DisplayName("커스텀 딜리미터 * 와 기본 딜리미터 , 있는 경우")
        void complexDelimiterTest1() {
            // given
            String source = "//*\\n1*2,3*4*";
            SeparateManager manager = SeparateManager.initiate();
            manager.extractCustomDelimiter(source);
            // when
            List<Integer> actual = manager.split(source);
            // then
            assertThat(actual.size()).isEqualTo(4);
        }

        @Test
        @DisplayName("커스텀 딜리미터 * 와 기본 딜리미터 쉼표, 콜론 있는 경우")
        void complexDelimiterTest2() {
            // given
            String source = "//*\\n1*2,3:4*";
            SeparateManager manager = SeparateManager.initiate();
            manager.extractCustomDelimiter(source);
            // when
            List<Integer> actual = manager.split(source);
            // then
            assertThat(actual.size()).isEqualTo(4);
        }

        @Test
        @DisplayName("[음수 포함] 커스텀 딜리미터 * 와 기본 딜리미터 쉼표, 콜론 있는 경우")
        void complexDelimiterTest3() {
            // given
            String source = "//*\\n1*2,3:-4*";
            SeparateManager manager = SeparateManager.initiate();
            manager.extractCustomDelimiter(source);
            // when
            List<Integer> actual = manager.split(source);
            // then
            assertThat(actual.size()).isEqualTo(4);
        }
    }
}
