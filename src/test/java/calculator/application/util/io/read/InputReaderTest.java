package calculator.application.util.io.read;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import java.io.InputStream;
import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

public class InputReaderTest {

    @ParameterizedTest(name = "({index}) : {0} ==> {1}")
    @CsvSource(
            value = {" 1&2&3 :1&2&3 ", " abcde :abcde", "ㄱㄴㄷㄹ:ㄱㄴㄷㄹ", "1,2,3,4 :1,2,3,4"},
            delimiter = ':'
    )
    void 정상_값_입력시_정상_결과_반환(String given, String expected) {
        // given
        InputStream line = new ByteArrayInputStream(given.getBytes());
        System.setIn(line);

        // when
        String result = InputReader.read();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "({index}) : '{arguments}' ==> IllegalArgumentException")
    @ValueSource(strings = { " ", "   ", "\n" })
    void 빈_값_입력시_IllegalArgumentException_반환(String given) {
        // given
        InputStream line = new ByteArrayInputStream(given.getBytes());
        System.setIn(line);

        // when & then
        assertThatThrownBy(InputReader::read)
                .isInstanceOf(IllegalArgumentException.class);
    }

}
