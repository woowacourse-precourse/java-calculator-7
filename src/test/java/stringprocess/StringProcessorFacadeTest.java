package stringprocess;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import constant.ErrorMessage;
import java.util.List;
import org.junit.jupiter.api.Test;

class StringProcessorFacadeTest {
    private final StringProcessorFacade processor = new StringProcessorFacade();

    @Test
    void 커스텀_구분자_사용() {
        //given
        String input = "//;\\n1";

        //when
        List<String> result = processor.process(input);

        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result).containsExactly("1");
    }

    @Test
    void 커스텀_구분자_여러_문자_테스트() {
        //given
        String input = "1,2:3://!a@b#c\\n4!a@b#c5!a@b#c6";

        //when
        List<String> result = processor.process(input);

        //then
        assertThat(result.size()).isEqualTo(6);
        assertThat(result).containsExactly("1", "2", "3", "4", "5", "6");

    }

    @Test
    void 두자리_이상_양수_테스트() {
        //given
        String input = "1,12:3://*\\n4*50*6*30";

        //when
        List<String> result = processor.process(input);

        //then
        assertThat(result.size()).isEqualTo(7);
        assertThat(result).containsExactly("1", "12", "3", "4", "50", "6", "30");

    }

    @Test
    void 커스텀_구분자_공백_예외_테스트() {
        //given
        String input = "1,2:3//\n456";

        //then
        assertThrows(IllegalArgumentException.class, () -> processor.process(input),
                ErrorMessage.SPACE_OR_CHANGING_CHAR_CANNOT_USE);

    }

    @Test
    void 커스텀_구분자_슬래쉬_예외_테스트() {
        //given
        String input = "1,2:3////\n456";

        //then
        assertThrows(IllegalArgumentException.class, () -> processor.process(input),
                ErrorMessage.CUSTOM_SEPARATOR_FORMAT_ERROR);
    }

    @Test
    void 커스텀_구분자에_양수_포함_예외_테스트() {
        //given
        String input = "1,2:3//4;\n4;56";

        //then
        assertThrows(IllegalArgumentException.class, () -> processor.process(input),
                ErrorMessage.CUSTOM_SEPARATOR_CONTAINS_NUM);

    }

    @Test
    void 커스텀_구분자_선언전_사용_예외_테스트() {
        //given
        String input = "1,2;3//;\n4;56";

        //then
        assertThrows(IllegalArgumentException.class, () -> processor.process(input),
                ErrorMessage.CUSTOM_SEPARATOR__DECLARATION_ORDER_ERROR);

    }

}