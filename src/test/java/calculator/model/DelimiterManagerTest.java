package calculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterManagerTest {
    @Test
    void 아무것도_추가되지않은_구분관리자의_동적표현식_테스트() {
        // given
        DelimiterManager manager = new DelimiterManager();
        // when
        System.out.println("=====Logic Start=====");
        String buildRegex = manager.buildRegex();
        System.out.println("=====Logic End=====");
        // then
        assertThat(buildRegex).isEqualTo("\\Q:\\E|\\Q,\\E");
    }
    @Test
    void 커스텀구분자_제거한_문자열반환() {
        // given
        DelimiterManager manager = new DelimiterManager();
        String input = "//;\\n1";
        // when
        System.out.println("=====Logic Start=====");

        String output = manager.removeCustomDelimiterFrom(input);

        System.out.println("=====Logic End=====");
        // then
        assertThat(output).isEqualTo("1");
    }

    @Test
    void 여러개의_커스텀구분자_제거한_문자열반환() {
        // given
        DelimiterManager manager = new DelimiterManager();
        String input = "//;\\n1//;\\n,3";
        // when
        System.out.println("=====Logic Start=====");

        String output = manager.removeCustomDelimiterFrom(input);

        System.out.println("=====Logic End=====");
        // then
        assertThat(output).isEqualTo("1,3");
    }
    @Test
    void 커스텀구분자가_아닌문자가_포함되었을떄_문자열반환() {
        // given
        DelimiterManager manager = new DelimiterManager();
        String input = "//;\\n1//;\\n,3\\";
        // when
        System.out.println("=====Logic Start=====");

        String output = manager.removeCustomDelimiterFrom(input);

        System.out.println("=====Logic End=====");
        // then
        assertThat(output).isEqualTo("1,3\\");
    }
}