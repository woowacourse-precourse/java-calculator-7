package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringProcessorTest {
    @Test
    @DisplayName("구분자를 기준으로 문자열을 분리한다")
    void 문자열_분리_구분자기준() {
        StringProcessor stringProcessor = new StringProcessor();

        Assertions.assertThat(stringProcessor.splitWithDelimiter("1,2,3")).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("덧셈 기능 구현")
    void 덧셈_기능_테스트() {
        StringProcessor stringProcessor = new StringProcessor();

        Assertions.assertThat(stringProcessor.calculate(new String[] {"1", "2", "3"})).isEqualTo(6);
    }

}
