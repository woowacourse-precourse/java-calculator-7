package separator;

import exception.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.regex.Matcher;

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
        String inputData = "//\\\\n2341@!2031@!22122";
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
        customSeparator.validateCustomSeparatorFormat();

        //then
    }

    @DisplayName("계산할 숫자가 없을 때, 초기값  설정")
    @Test
    void findGroupOrDefault() {
        //given
        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
        String inputData = "//\\n";
        CustomSeparator customSeparator = new CustomSeparator(inputData,customSeparatorFormat);
        Matcher matcher = customSeparatorFormat.getPattern().matcher(inputData);

        //when

        String groupOrDefault = customSeparator.findGroupOrDefault(matcher);
        //then
        Assertions.assertThat(groupOrDefault).isEqualTo("0");
    }

    @DisplayName("inputDaga 가져오기")
    @Test
    void getInputData() {
        //given
        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
        String inputData = "//@!\\n1@!2@!3";
        CustomSeparator customSeparator = new CustomSeparator(inputData,customSeparatorFormat);


        //when
        String inputData1 = customSeparator.getInputData();
        //then
        Assertions.assertThat(inputData1).isEqualTo(inputData);
    }


    @DisplayName("계산할 숫자가 없을 때, 초기값  설정")
    @Test
    void splitGroupByCustomSeparator() {
        //given
        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
        String inputData = "3//@\\n1@2@3";
        CustomSeparator customSeparator = new CustomSeparator(inputData,customSeparatorFormat);
        Matcher matcher = customSeparatorFormat.getPattern().matcher(inputData);
        String groupOrDefault1 = customSeparator.findGroupOrDefault(matcher);

        //when
        String[] strings = customSeparator.splitGroupByCustomSeparator(groupOrDefault1);

        //then
        Assertions.assertThat(strings[0]).isEqualTo("1");
    }


    @DisplayName("구분자가 없을 때, 숫자만 반환")
    @Test
    void EmptyCustomSeparate() {
        //given
        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
        String inputData = "//\\n123";
        CustomSeparator customSeparator = new CustomSeparator(inputData,customSeparatorFormat);

        //when
        String[] strings1 = customSeparator.splitInputDataBySeparator();

        //then
        Assertions.assertThat(strings1[0]).isEqualTo("123");
    }


    @DisplayName("구분자를 찾을 수 없을 때, 에러 반환")
    @Test
    void findSeparator() {
        //given
        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
        String inputData = "//\\n123";
        String inputData2 = "//\\n";
        CustomSeparator customSeparator = new CustomSeparator(inputData,customSeparatorFormat);
        CustomSeparator customSeparator2 = new CustomSeparator(inputData2,List.of(""),customSeparatorFormat);

        //when
        String separator = customSeparator.findSeparator();
        String separator2 = customSeparator2.findSeparator();

        //then
        Assertions.assertThat(separator).isEqualTo("");
        Assertions.assertThat(separator2).isEqualTo("");
    }



}