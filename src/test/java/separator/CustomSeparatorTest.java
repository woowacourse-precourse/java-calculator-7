package separator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class CustomSeparatorTest {
    @DisplayName("커스텀구분자에 숫자는 들어갈 수 없다.")
    @Test
    void validateCustomSeparator() {
        //given
        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
        String inputData = "//4\n2341@!2031@!22122";
        CustomSeparator customSeparator = new CustomSeparator(inputData, List.of("4"),customSeparatorFormat);
        //when

        //then
        Assertions.assertThatThrownBy(() ->
                customSeparator.validateCustomSeparator("4")

        ).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("문자열에 포함된 숫자를 가져올 수 있다.")
    @Test
    void splitInputDataBySeparator() {
        //given
        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
        String inputData ="//@!\\n2341@!2031@!22122";
        CustomSeparator customSeparator = new CustomSeparator(inputData,customSeparatorFormat);
        //when
        String[] split = customSeparator.splitInputDataBySeparator();
        //then
        Assertions.assertThat(split[0]).isEqualTo("2341");

    }

}