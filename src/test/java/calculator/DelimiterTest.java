package calculator;

import calculator.model.Delimiter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DelimiterTest {

    @Test
    @DisplayName("빈문자열 분리 테스트")
    void 빈문자열_분리_테스트() {
        Delimiter delimiter = new Delimiter();

        Assertions.assertThat(delimiter.splitWithCustomDelimiter("")).containsExactly("");
    }

    @Test
    @DisplayName("구분자를 기준으로 문자열을 분리한다")
    void 문자열_분리_구분자기준() {
        Delimiter delimiter = new Delimiter();

        Assertions.assertThat(delimiter.splitWithDelimiter("1,2,3")).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자 분리 테스트")
    void 커스텀_구분자_기준_분리() {
        Delimiter delimiter = new Delimiter();

        Assertions.assertThat(delimiter.splitWithCustomDelimiter("//;\n1;2;3")).containsExactly("1", "2", "3");
    }

}
