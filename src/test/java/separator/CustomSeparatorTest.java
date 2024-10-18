package separator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
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
        System.out.println("inputData : "+inputData);
        CustomSeparator customSeparator = new CustomSeparator(inputData,customSeparatorFormat);
        System.out.println("customSeparator.getSeparator().get(0) : "+customSeparator.getSeparator().get(0));
        //when
        String[] split = customSeparator.splitInputDataBySeparator();
        System.out.println("customSeparator.getSeparator().size()"+customSeparator.getSeparator().size());
        //then
        Assertions.assertThat(split[0]).isEqualTo("2341");

    }

}