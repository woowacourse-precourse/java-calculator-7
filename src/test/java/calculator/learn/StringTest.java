package calculator.learn;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void splitTest() {
        String test = "//;\\n1";
        String[] split = test.split("\\\\n");
        assertThat(split.length).isEqualTo(2);
    }

}
