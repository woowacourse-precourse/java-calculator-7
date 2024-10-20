package stringprocess;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
                "공백 또는 \"\\n\"은 커스텀 구분자로 사용이 불가합니다.");

    }

    @Test
    void 커스텀_구분자_슬래쉬_예외_테스트() {
        //given
        String input = "1,2:3////\n456";

        //then
        assertThrows(IllegalArgumentException.class, () -> processor.process(input),
                "커스텀 구분자 형식이 올바르지 않습니다.");
    }

    @Test
    void 커스텀_구분자에_양수_포함_예외_테스트() {
        //given
        String input = "1,2:3//4;\n4;56";

        //then
        assertThrows(IllegalArgumentException.class, () -> processor.process(input),
                "커스텀 구분자에는 양수가 포함될 수 없습니다.");

    }

    @Test
    void 커스텀_구분자_선언전_사용_예외_테스트() {
        //given
        String input = "1,2;3//;\n4;56";

        //then
        assertThrows(IllegalArgumentException.class, () -> processor.process(input),
                "커스텀 구분자 선언이 사용보다 선행되어야합니다.");
        
    }

}