package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.dto.Data;
import org.junit.jupiter.api.Test;

class DataParserTest {

    @Test
    void 올바른_데이터_파싱() {
        String inputData = "1,2,3";
        Data data = DataParser.parseData(inputData);

        String contents = data.getContents();
        String separators = data.getSeparators();

        assertThat(contents).isEqualTo("1,2,3");
        assertThat(separators).isEqualTo("[,:]");
    }
}