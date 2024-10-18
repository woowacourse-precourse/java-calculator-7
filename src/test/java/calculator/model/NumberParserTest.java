package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberParserTest {

    NumberParser parser = new NumberParser();


    @Test
    @DisplayName("양수 문자열을 정수로 변환할 수 있다.")
    void 양수_문자열을_정수로_변환_성공() {

        //given
        String[] validInput = {"100", "200", "0", "50", "0.1",
                String.valueOf(Integer.MAX_VALUE),
                String.valueOf(Long.MAX_VALUE),
                String.valueOf(Double.MAX_VALUE)};

        //when
        List<Number> result = parser.parse(validInput);

        //then
        assertThat(result)
                .containsExactly(100, 200, 0, 50, 0.1,
                        Integer.MAX_VALUE,
                        Long.MAX_VALUE,
                        Double.MAX_VALUE);
    }

    @Test
    @DisplayName("유효하지 않은 문자열을 변환 시도 시 예외 발생")
    void 양수_문자열을_정수로_변환_실패() {

        //given
        String[] validInput = {"fail", "test", "code", "50", "0.1",
                String.valueOf(Integer.MAX_VALUE),
                String.valueOf(Long.MAX_VALUE),
                String.valueOf(Double.MAX_VALUE)};

        // when then
        assertThatThrownBy(() -> parser.parse(validInput))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
