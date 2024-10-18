package calculator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputReaderTest {

    InputReader reader = new InputReader();

    @Test
    public void read_함수_테스트() {
        // given
        String givenCommand = "1,2";

        InputStream in = new ByteArrayInputStream(givenCommand.getBytes());
        System.setIn(in);

        // when
        String output = reader.read();

        // then
        Assertions.assertThat(output).isEqualTo(givenCommand);
    }

}