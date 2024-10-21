package calculator.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    void 커스텀구분자가_없는_입력을_잘_분리한다() {
        //given
        InputParser sut = new InputParser();

        //when
        InputParseResult result = sut.parse("1:2:3^4;5");

        //then
        Assertions.assertThat(result.customSeparatorPart()).isEqualTo("");
        Assertions.assertThat(result.numberPart()).isEqualTo("1:2:3^4;5");
    }

    @Test
    void 커스텀구분자가_없는_두자리_이상의_숫자_입력을_잘_분리한다() {
        //given
        InputParser sut = new InputParser();

        //when
        InputParseResult result = sut.parse("1:12:123^1234;12345");

        //then
        Assertions.assertThat(result.customSeparatorPart()).isEqualTo("");
        Assertions.assertThat(result.numberPart()).isEqualTo("1:12:123^1234;12345");
    }

    @Test
    void 커스텀구분자가_있는_입력을_잘_분리한다() {
        //given
        InputParser sut = new InputParser();

        //when
        InputParseResult result = sut.parse("//^\\n1:2:3^4;5");

        //then
        Assertions.assertThat(result.customSeparatorPart()).isEqualTo("^");
        Assertions.assertThat(result.numberPart()).isEqualTo("1:2:3^4;5");
    }

    @Test
    void 여러개의_커스텀구분자가_있는_입력을_잘_분리한다() {
        //given
        InputParser sut = new InputParser();

        //when
        InputParseResult result = sut.parse("//^&*\\n1:2:3^4;5");

        //then
        Assertions.assertThat(result.customSeparatorPart()).isEqualTo("^&*");
        Assertions.assertThat(result.numberPart()).isEqualTo("1:2:3^4;5");
    }

    @Test
    void 역슬래쉬_커스텀구분자가_있는_입력을_잘_분리한다() {
        //given
        InputParser sut = new InputParser();

        //when
        InputParseResult result = sut.parse("//^&*\\\\n1:2:3^4;5");

        //then
        Assertions.assertThat(result.customSeparatorPart()).isEqualTo("^&*\\");
        Assertions.assertThat(result.numberPart()).isEqualTo("1:2:3^4;5");
    }

    @Test
    void 커스텀구분자가_있고_숫자가_두자리_이상인_입력을_잘_분리한다() {
        //given
        InputParser sut = new InputParser();

        //when
        InputParseResult result = sut.parse("//^\\n1:12:123^4;5");

        //then
        Assertions.assertThat(result.customSeparatorPart()).isEqualTo("^");
        Assertions.assertThat(result.numberPart()).isEqualTo("1:12:123^4;5");
    }

    @Test
    void 여러개의_커스텀구분자가_있고_숫자가_여러개인_입력을_잘_분리한다() {
        //given
        InputParser sut = new InputParser();

        //when
        InputParseResult result = sut.parse("//^&*\\n1:12:123^4;5");

        //then
        Assertions.assertThat(result.customSeparatorPart()).isEqualTo("^&*");
        Assertions.assertThat(result.numberPart()).isEqualTo("1:12:123^4;5");
    }

}