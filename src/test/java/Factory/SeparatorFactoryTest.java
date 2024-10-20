package Factory;

import exception.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import separator.CustomSeparatorFormat;
import separator.Separator;

import java.util.List;

class SeparatorFactoryTest {

    @DisplayName("시작문자가 숫자가 아니면 커스텀구분자를 생성한다.")
    @Test
    void generateCustomSeparators() {
        //given
        List<String> defaultSeparators = List.of(",", ":");
        String inputData ="//@!\\n2341@!2031@!22122";
        SeparatorFactory separatorFactory = new SeparatorFactory(defaultSeparators,new CustomSeparatorFormat(),inputData);
        //when
        Separator separator = separatorFactory.generateSeparators();

        //then
        Assertions.assertThat(separator.getSeparator().get(0)).isEqualTo("@!");
    }

    @DisplayName("시작문자가 숫자면 기본구분자를 생성한다.")
    @Test
    void generateDefaultSeparators() {
        //given
        List<String> defaultSeparators = List.of(",", ":");
        String inputData ="2341,2031:22122";
        SeparatorFactory separatorFactory = new SeparatorFactory(defaultSeparators,new CustomSeparatorFormat(),inputData);
        //when
        Separator separator = separatorFactory.generateSeparators();

        //then
        Assertions.assertThat(separator.getSeparator().get(0)).isEqualTo(",");
    }

    @DisplayName("시작문자가 숫자면 true, 문자면 false 리턴")
    @Test
    void validateStartChar() {
        //given
        List<String> defaultSeparators = List.of(",", ":");
        String inputData ="2341,2031:22122";
        String inputData2 ="//!@\\n2341,2031:22122";
        String inputData3 ="?//!@\\n2341,2031:22122";
        SeparatorFactory separatorFactory = new SeparatorFactory(defaultSeparators,new CustomSeparatorFormat(),inputData);
        SeparatorFactory separatorFactory2 = new SeparatorFactory(defaultSeparators,new CustomSeparatorFormat(),inputData2);
        SeparatorFactory separatorFactory3 = new SeparatorFactory(defaultSeparators,new CustomSeparatorFormat(),inputData3);
        String replaceInput = inputData.replace(" ", "");
        String replaceInput2 = inputData2.replace(" ", "");
        String replaceInput3 = inputData3.replace(" ", "");

        //when
        Boolean aBoolean = separatorFactory.isDefaultSeparator(replaceInput);
        Boolean aBoolean2 = separatorFactory2.isDefaultSeparator(replaceInput2);


        //then
        Assertions.assertThat(aBoolean).isTrue();
        Assertions.assertThat(aBoolean2).isFalse();
        Assertions.assertThatThrownBy(() -> separatorFactory3.isDefaultSeparator(replaceInput3)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_CUSTOM_SEPARATOR_FORMAT.getMessage());
    }

    @DisplayName("input값의 공백을 제거한다.")
    @Test
    void normalizeInputData() {
        //given
        List<String> defaultSeparators = List.of(",", ":");
        String inputData ="  2341,2031:22122";
        String inputData2 ="  ";
        SeparatorFactory separatorFactory = new SeparatorFactory(defaultSeparators,new CustomSeparatorFormat(),inputData);
        String replaceInput = inputData.replace(" ", "");
        String replaceInput2 = inputData2.replace(" ", "");


        //when
        String s = separatorFactory.replaceBlankOrEmptyWithDefault(replaceInput);
        String s2 = separatorFactory.replaceBlankOrEmptyWithDefault(replaceInput2);

        //then
        Assertions.assertThat(s).isEqualTo("2341,2031:22122");
        Assertions.assertThat(s2).isEqualTo("0");
    }

}