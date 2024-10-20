import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.delimiterStrategy.CustomDelimiterStrategy;
import calculator.delimiterStrategy.DelimiterStrategy;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("구분자 설정 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DelimiterStrategyTest {
    @Test
    void 커스텀_구분자를_올바르게_사용했다() {
        //given
        DelimiterStrategy delimiterStrategy = new CustomDelimiterStrategy();
        //when
        List<String> customDelimiter = delimiterStrategy.decideDelimiter("//;\\n1;2;3");
        //then
        assertThat(customDelimiter).isEqualTo(List.of(";"));
    }

    @Test
    void 커스텀_구분자로_숫자가_들어오면_예외가_발생한다() {
        //given
        DelimiterStrategy delimiterStrategy = new CustomDelimiterStrategy();
        //when //then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> delimiterStrategy.decideDelimiter("//6\n1"));
        assertThat(e.getMessage()).isEqualTo("커스텀 구분자는 숫자를 포함하면 안 된다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//&!\n1:2", "// b\n1:2"})
    void 커스텀_구분자로_여러_문자가_들어오면_예외가_발생한다(String userInput) {
        //given
        DelimiterStrategy delimiterStrategy = new CustomDelimiterStrategy();
        //when
        //then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> delimiterStrategy.decideDelimiter(userInput));
        assertThat(e.getMessage()).isEqualTo("하나의 문자만 커스텀 구분자로 지정한다");
    }
}
