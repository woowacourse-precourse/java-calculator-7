package calculator.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CustomDataParserTest {

    @Test
    void 커스텀_데이터_파싱_테스트() {
        //given
        String inputData = "//;\\n1;2;3";
        CustomDataParser customDataParser = new CustomDataParser();

        //when
        List<Integer> numbers = customDataParser.parseData(inputData);

        //then
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers).contains(1);
        assertThat(numbers).contains(2);
        assertThat(numbers).contains(3);
    }

    @Test
    void 커스텀_데이터_파싱_테스트_구분자_먼저() {
        //given
        String inputData = "//;\\n;;,1;2;3";
        CustomDataParser customDataParser = new CustomDataParser();

        //when
        List<Integer> numbers = customDataParser.parseData(inputData);

        //then
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers).contains(1);
        assertThat(numbers).contains(2);
        assertThat(numbers).contains(3);
    }

    @Test
    void 일반_데이터_파싱_테스트_구분자_아님_예외_발생() {
        //given
        String inputData = ",1,2,'34";
        CustomDataParser customDataParser = new CustomDataParser();

        assertThrows(IllegalArgumentException.class, () -> {
            customDataParser.parseData(inputData);
        });
    }

    @Test
    void 일반_데이터_파싱_테스트_오버플러우_예외_발생() {
        //given
        String inputData = ",1,2,2147483648";
        CustomDataParser customDataParser = new CustomDataParser();

        assertThrows(IllegalArgumentException.class, () -> {
            customDataParser.parseData(inputData);
        });
    }

}