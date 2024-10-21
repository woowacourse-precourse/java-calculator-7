package calculator;

import calculator.reader.ConsoleReader;
import calculator.reader.Reader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ConsoleReaderTest {

    Reader reader = new ConsoleReader();

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