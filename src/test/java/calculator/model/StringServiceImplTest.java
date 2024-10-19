package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringServiceImplTest {
    private StringServiceImpl stringService;

    @BeforeEach
    void create() {
        stringService = new StringServiceImpl();
    }

    @Test
    void 기본_파싱() {
        //given
        String input = "1,2:3";

        //when
        List<String> parsedList = stringService.parse(input);

        //then
        assertThat(parsedList)
                .isEqualTo(new ArrayList<>(Arrays.asList("1", "2", "3")));
    }

    @Test
    void 기본_파싱_숫자_하나만() {
        //given
        String input = "1";

        //when
        List<String> parsedList = stringService.parse(input);

        //then
        assertThat(parsedList)
                .isEqualTo(new ArrayList<>(List.of("1")));
    }

    @Test
    void 기본_잘못된_구분자_사용() {
        //given
        String input = "1;2;3";

        //when
        assertThatThrownBy(() -> stringService.parse(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 기본_잘못된_형식() {
        //given
        String input = "1;2;3";

        //when
        assertThatThrownBy(() -> stringService.parse(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_파싱() {
        //given
        String input = "//-\\n1-2-3";

        //when
        List<String> parsedList = stringService.parse(input);

        //then
        assertThat(parsedList)
                .isEqualTo(new ArrayList<>(Arrays.asList("1", "2", "3")));
    }

    @Test
    void 커스텀_파싱_숫자_하나() {
        //given
        String input = "//-\\n1";

        //when
        List<String> parsedList = stringService.parse(input);

        //then
        assertThat(parsedList)
                .isEqualTo(new ArrayList<>(List.of("1")));
    }

    @Test
    void 커스텀_파싱_빈_문자열() {
        //given
        String input = "//-\\n";

        //when
        List<String> parsedList = stringService.parse(input);

        //then
        assertThat(parsedList)
                .isEqualTo(new ArrayList<>());
    }

    @Test
    void 커스텀_파싱_구분자가_정규표현식_기호() {
        //given
        String input = "//|\\n1|2|3";

        //when
        List<String> parsedList = stringService.parse(input);

        //then
        assertThat(parsedList)
                .isEqualTo(new ArrayList<>(Arrays.asList("1", "2", "3")));
    }

    @Test
    void 커스텀_파싱_구분자가_문자_여러개() {
        //given
        String input = "//**\\n1**2**3";

        //when
        List<String> parsedList = stringService.parse(input);

        //then
        assertThat(parsedList)
                .isEqualTo(new ArrayList<>(Arrays.asList("1", "2", "3")));
    }

    @DisplayName("커스텀 input 파싱 예외")
    @Test
    void 커스텀_잘못된_형식() {
        //given
        String input = "//1;a;3";

        //when
        assertThatThrownBy(() -> stringService.parse(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_잘못딘_구분자_사용() {
        //given
        String input = "//|\\n1;2|3";

        //when
        assertThatThrownBy(() -> stringService.parse(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 기본_빈_문자열_파싱() {
        //given
        String input = "";

        //when
        List<String> parsedList = stringService.parse(input);

        assertThat(parsedList)
                .isEqualTo(new ArrayList<>());
    }

    @Test
    void 문자열리스트_정수리스트로_변환() {
        //given
        List<String> stringList = new ArrayList<>(Arrays.asList("1", "2", "3"));

        //when
        List<Integer> integerList = stringService.toIntegerList(stringList);

        //then
        assertThat(integerList)
                .isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3)));
    }

    @Test
    void 문자열리스트_정수리스트로_변환_예외() {
        //given
        List<String> stringList = new ArrayList<>(Arrays.asList("1", "a", "3"));

        //when
        assertThatThrownBy(() -> stringService.toIntegerList(stringList)).isInstanceOf(IllegalArgumentException.class);
    }

}