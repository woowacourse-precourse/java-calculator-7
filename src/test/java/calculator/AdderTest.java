package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class AdderTest {

    private static final Adder adder = new Adder();

    @Test
    void 구분자_쉼표_테스트() {
        String input = "1,2,3";

        int result = adder.run(input);

        assertThat(result).isEqualTo(6);
    }
}
