package calculator;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputDataReaderTest {
    @Test
    void 사용자_입력_반환_테스트() {
        //given
        String data = "1,2,3";
        byte[] buf = String.join("\n", data).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        //when
        String result = InputDataReader.getInputData();

        //then
        Assertions.assertEquals(result, data);
    }
}