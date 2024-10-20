package calculator.separator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomSeparatorManagerTest {

    @DisplayName("문자열에 존재하는 커스텀 구분자를 모두 찾는다.")
    @Test
    void findAllCustomSeparators() {
        //given
        String str = "//.\\n//?\\n//|\\n//1\\n1234//s\\n";
        CustomSeparatorManager customSeparatorManager = new CustomSeparatorManager();

        //when
        Separators result = customSeparatorManager.findAllCustomSeparators(str);

        //then
        assertThat(result.toString()).contains(".", "?", "|", "1");
        assertThat(result.toString()).doesNotContain("s", "1234");
    }

    @DisplayName("문자열에 존재하는 모든 커스텀 구분자를 자른 부분을 반환한다.")
    @Test
    void sliceCustomSeparators() {
        //given
        String str = "//.\\n//?\\n//|\\n//1\\n1.2,3?4";
        CustomSeparatorManager customSeparatorManager = new CustomSeparatorManager();

        //when
        String result = customSeparatorManager.sliceCustomSeparators(str);

        //then
        assertThat(result).isEqualTo("1.2,3?4");
    }

}