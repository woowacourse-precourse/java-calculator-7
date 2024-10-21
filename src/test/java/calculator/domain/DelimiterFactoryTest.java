package calculator.domain;

import static calculator.domain.DelimiterFactory.create;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterFactoryTest {

    @DisplayName("기본 구분자는 쉼표(,)와 콜론(:)")
    @EmptySource
    @ValueSource(strings = {"0", "1,", "1,2", "1,2:3"})
    @ParameterizedTest(name = "\"{0}\"은 기본 구분자 입력")
    void 기본_구분자_생성_성공(String input) {
        assertThat(create(input)).isInstanceOf(DefaultDelimiter.class);
    }

    @DisplayName("기본 구분자외 문자가 들어가면 실패")
    @ValueSource(strings = {"+", "1.", "1+2", "1,2;3"})
    @ParameterizedTest(name = "\"{0}\"은 기본 구분자가 아님")
    void 기본_구분자_생성_실패(String input) {
        assertThatThrownBy(() -> create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("커스텀 구분자는 //와 \\n 사이에 위치한 1 ~ 3자리 문자")
    @ValueSource(strings = {"// \\n1 2 3", "//;;\\n1;;2;;3", "// + \\n1 + 2 + 3", "// \\n1;2;3"})
    @ParameterizedTest(name = "\"{0}\"은 커스텀 구분자 입력")
    void 커스텀_구분자_생성_성공(String input) {
        assertThat(create(input)).isInstanceOf(CustomDelimiter.class);
    }

    @DisplayName("커스텀 구분자가 빈 문자이거나 4자리 이상은 실패, 구분한 문자의 양수 판단 여부는 구분자의 책임이 아님")
    @ValueSource(strings = {"//\\n123", "// ## \\n1;2;3"})
    @ParameterizedTest(name = "\"{0}\"은 커스텀 구분자가 아님")
    void 커스텀_구분자_생성_실패(String input) {
        assertThatThrownBy(() -> create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
