package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class SeparatorTest {
    @Test
    void 문자열_입력_테스트() {
        Separator separator = new Separator("1,2,3:4,5:6");
        assertThat(separator.getCurrentString()).isEqualTo("1,2,3:4,5:6");
    }

    @Test
    void 문자열_분리_테스트() {
        Separator separator = new Separator("1,2,3:4,5:6");
        assertThat(separator.cut()).isEqualTo(new String[]{"1", "2", "3", "4", "5", "6"});
    }

    @Test
    void 커스텀구분자_테스트() {
        Separator separator = new Separator("//;\\n1,2,3:4,5:6");
        separator.cut();

        assertThat(separator.getSeparator()).isEqualTo(",|:|;");
    }

    @Test
    void 커스텀구분자_분리_테스트() {
        Separator separator = new Separator("//;\\n1;2,3:4;5:6;;");
        assertThat(separator.cut()).isEqualTo(new String[]{"1", "2", "3", "4", "5", "6"});
    }

    @Test
    void 구분자_생성부_제거_테스트() {
        Separator separator = new Separator("//;\\n1;2,3:4,5:6;;");
        separator.cut();

        assertThat(separator.getCurrentString()).isEqualTo("1;2,3:4,5:6;;");
    }
}
