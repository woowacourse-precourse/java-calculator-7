import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.numberStrategy.NumberStrategy;
import calculator.numberStrategy.SimpleNumberStrategy;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberStrategyTest {
    @Test
    void 문자열에서_숫자를_올바르게_추출했다() {
        //given
        NumberStrategy numberStrategy = new SimpleNumberStrategy();
        //when
        List<Integer> inputNumbers = numberStrategy.extractNumber("100,3421:1", List.of(",", ":"));
        //then
        assertThat(inputNumbers).isEqualTo(List.of(100, 3421, 1));
    }

    @ParameterizedTest
    @ValueSource(strings = {":", "1:", "1,2:3,"})
    void 구분자가_문자열을_2개로_분리하지_않으면_예외가_발생한다(String userInput) { //문자열 0개 분리, 문자열 1개 분리
        //given
        NumberStrategy numberStrategy = new SimpleNumberStrategy();
        //when
        //then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> numberStrategy.extractNumber(userInput, List.of(":", ",")));
        assertThat(e.getMessage()).isEqualTo("구분자는 2개의 문자열을 분리해야 한다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1:2", "4,b,2", "1,^7", " ", " 2"})
    void 양수가_아닌_문자를_숫자로_변환하면_예외가_발생한다(String userInput) { //음수, 영문자, 특수기호, 공백
        //given
        NumberStrategy numberStrategy = new SimpleNumberStrategy();
        //when
        //then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> numberStrategy.extractNumber(userInput, List.of(",", ":")));
        assertThat(e.getMessage()).isEqualTo("양수 이외에 다른 문자가 들어왔다");
    }

}
