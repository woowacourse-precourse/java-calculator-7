package calculator.adder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class NumberAdderTest {

    @Test
    void 숫자_들을_성공적으로_더한다() {
        // given
        List<String> value = List.of("1", "2", "3");
        NumberAdderRequest numberAdderRequest = NumberAdderRequest.of(value);

        // when
        NumberAdder numberAdder = new NumberAdderImpl();
        NumberAdderResponse numberAdderResponse = numberAdder.addNumberToken(numberAdderRequest);

        // then
        assertThat(numberAdderResponse.getValue()).isEqualTo(6);
    }
}
