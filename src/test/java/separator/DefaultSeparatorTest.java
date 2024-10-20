package separator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class DefaultSeparatorTest {

    @DisplayName("기본구분자를 가져온다.")
    @Test
    void getSeparator() {
        //given
        String inputData = "1,2,3";
        DefaultSeparator defaultSeparator = new DefaultSeparator(inputData, List.of(",", ":","@"));
        //when
        List<String> separator = defaultSeparator.getSeparator();
        //then
        Assertions.assertThat(separator.get(0)).isEqualTo(",");
        Assertions.assertThat(separator).hasSize(3);
    }

    @DisplayName("기본구분자를 기준으로 InputData를 자른다.")
    @Test
    void splitInputDataBySeparator() {
        //given
        String inputData = "1,2,3";
        DefaultSeparator defaultSeparator = new DefaultSeparator(inputData, List.of(",", ":"));
        //when
        String[] strings = defaultSeparator.splitInputDataBySeparator();
        //then
        Assertions.assertThat(strings[0]).isEqualTo("1");
    }

    @DisplayName("InputData를 가져온다.")
    @Test
    void getInputData() {
        String inputData = "1,2,3";
        DefaultSeparator defaultSeparator = new DefaultSeparator(inputData, List.of(",", ":"));
        //when
        String inputData1 = defaultSeparator.getInputData();
        //then
        Assertions.assertThat(inputData1).isEqualTo("1,2,3");
    }

    @DisplayName("여러개의 기본구분자를 하나의 or 문으로 조합할 수 있다.")
    @Test
    void createOrString() {
        String inputData = "1,2,3";
        DefaultSeparator defaultSeparator = new DefaultSeparator(inputData, List.of(",", ":","@"));
        //when
        String createOrString = defaultSeparator.createOrString();
        //then
        Assertions.assertThat(createOrString).isEqualTo(",|:|@");
    }
}