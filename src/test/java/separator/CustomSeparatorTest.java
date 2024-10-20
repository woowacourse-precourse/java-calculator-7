package separator;

import Factory.SeparatorFactory;
import exception.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class CustomSeparatorTest {
    @DisplayName("커스텀구분자에 숫자는 들어갈 수 없다.")
    @Test
    void validateCustomSeparatorFormatNotContainNumber() {
        //given
        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
        String inputData = "//4\n2341@!2031@!22122";
        CustomSeparator customSeparator = new CustomSeparator(inputData, List.of("4"),customSeparatorFormat);
        //when

        //then
        Assertions.assertThatThrownBy(customSeparator::validateCustomSeparatorFormat

        ).isInstanceOf(IllegalArgumentException.class).hasMessage(ExceptionMessage.INVALID_CUSTOM_SEPARATOR_CONTAINS_NUMBER.getMessage());

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



    @DisplayName("inputData 값이 커스텀구분자 포멧과 일치하지 않으면 에러 출력")
    @Test
    void validateCustomSeparatorFormat_NotMatch() {
        //given
        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
        String inputData = "?/@!\n2341@!2031@!22122";
        CustomSeparator customSeparator = new CustomSeparator(inputData, List.of("@!"),customSeparatorFormat);

        //when

        //then
        Assertions.assertThatThrownBy(customSeparator::validateCustomSeparatorFormat).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_CUSTOM_SEPARATOR_FORMAT.getMessage());
    }


    @DisplayName("커스텀구분자에 백스페이스 들어오면 에러 출력")
    @Test
    void validateCustomSeparatorFormat_NotBackSpace() {
        //given
        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
        String inputData = "//\\\n2341@!2031@!22122";
        CustomSeparator customSeparator = new CustomSeparator(inputData, List.of("@!"),customSeparatorFormat);

        //when

        //then
        Assertions.assertThatThrownBy(customSeparator::validateCustomSeparatorFormat).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_CUSTOM_SEPARATOR_CONTAINS_BACKSPACE.getMessage());
    }
    @DisplayName("구분자가 없을 때 에러 출력")
    @Test
    void validateCustomSeparatorFormat_NotEmpty() {
        //given
        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
        String inputData = "//\\n2341@!2031@!22122";
        CustomSeparator customSeparator = new CustomSeparator(inputData,customSeparatorFormat);

        //when
        System.out.println(customSeparator.getSeparator().get(0));
        customSeparator.validateCustomSeparatorFormat();

        //then
    }

}