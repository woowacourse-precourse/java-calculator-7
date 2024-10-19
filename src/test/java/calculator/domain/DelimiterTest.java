package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterTest {

    private Delimiter delimiter;

    @BeforeEach
    void setUp() {
        delimiter = new Delimiter();
    }

    @ValueSource(strings = {"", "1", "1,", ":1", "1,2:3", ",|"})
    @ParameterizedTest(name = "\"{0}\"은 기본 구분자")
    @DisplayName("기본 구분자 일치: 빈 문자열, 숫자만 존재, 쉼표(,) 또는 콜론(:)을 사용해 구분")
    void 기본_구분자_일치(String input) {
        assertThat(delimiter.isDefault(input)).isTrue();
    }

    @ValueSource(strings = {"1.", "!1", "1,2:3;4", ",|;"})
    @ParameterizedTest(name = "\"{0}\"은 기본 구분자가 아님")
    @DisplayName("기본 구분자 불일치: 쉼표(,) 또는 콜론(:)외 포함")
    void 기본_구분자_불일치(String input) {
        assertThat(delimiter.isDefault(input)).isFalse();
    }

    @ValueSource(strings = {"//;\n1;2;3", "// \n1 2 3", "//;\n1", "// \n"})
    @ParameterizedTest(name = "\"{0}\"은 커스텀 구분자")
    @DisplayName("커스텀 구분자 일치: //와 \n 사이에 1개 이상의 문자가 존재")
    void 커스텀_구분자_일치(String input) {
        assertThat(delimiter.isCustom(input)).isTrue();
    }

    @Test
    @DisplayName("커스텀 구분자 불일치: 빈 문자열은 커스텀 구분자가 아님")
    void 커스텀_구분자_불일치() {
        assertThat(delimiter.isCustom("//\n")).isFalse();
    }

}
