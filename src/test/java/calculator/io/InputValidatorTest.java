package calculator.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 커스텀구분자가_없는_정상입력은_통과한다() {
        //given
        InputValidator sut = new InputValidator();

        //expected
        Assertions.assertThatCode(() -> sut.validate("1:2;3"))
                .doesNotThrowAnyException();
    }

    @Test
    void 커스텀구분자가_없는_두자리_이상의_숫자로_구성된_정상입력은_통과한다() {
        //given
        InputValidator sut = new InputValidator();

        //expected
        Assertions.assertThatCode(() -> sut.validate("1:12;123"))
                .doesNotThrowAnyException();
    }

    @Test
    void 커스텀구분자가_있는_정상입력은_통과한다() {
        //given
        InputValidator sut = new InputValidator();

        //expected
        Assertions.assertThatCode(() -> sut.validate("//^\\n1:2;3"))
                .doesNotThrowAnyException();
    }

    @Test
    void 커스텀구분자가_두개_이상_있는_정상입력은_통과한다() {
        //given
        InputValidator sut = new InputValidator();

        //expected
        Assertions.assertThatCode(() -> sut.validate("//^&*\\n1:2;3"))
                .doesNotThrowAnyException();
    }

    @Test
    void 역슬래쉬_커스텀구분자가_있는_정상입력은_통과한다() {
        //given
        InputValidator sut = new InputValidator();

        //expected
        Assertions.assertThatCode(() -> sut.validate("//^&*\\\\n1:2;3"))
                .doesNotThrowAnyException();
    }

    @Test
    void 커스텀구분자가_있고_숫자가_두자리_이상인_정상입력은_통과한다() {
        //given
        InputValidator sut = new InputValidator();

        //expected
        Assertions.assertThatCode(() -> sut.validate("//^\\n1:12;123"))
                .doesNotThrowAnyException();
    }

    @Test
    void 커스텀구분자가_여러개_있고_숫자가_두자리_이상인_정상입력은_통과한다() {
        //given
        InputValidator sut = new InputValidator();

        //expected
        Assertions.assertThatCode(() -> sut.validate("//^&*\\n1:12;123"))
                .doesNotThrowAnyException();
    }

    @Test
    void 커스텀구분자_시작슬래쉬가_온전하지_않은_입력은_실패한다() {
        //given
        InputValidator sut = new InputValidator();

        //expected
        Assertions.assertThatThrownBy(() -> sut.validate("/^&*\\n1:12;123"));
    }

    @Test
    void 커스텀구분자_시작슬래쉬가_존재하지_않은_입력은_실패한다() {
        //given
        InputValidator sut = new InputValidator();

        //expected
        Assertions.assertThatThrownBy(() -> sut.validate("^&*\\n1:12;123"));
    }

    @Test
    void 커스텀구분자_종료역슬래쉬가_없는_입력은_실패한다() {
        //given
        InputValidator sut = new InputValidator();

        //expected
        Assertions.assertThatThrownBy(() -> sut.validate("//^&*n1:12;123"));
    }

    @Test
    void 커스텀구분자_종료n이_온전하지_않은_입력은_실패한다() {
        //given
        InputValidator sut = new InputValidator();

        //expected
        Assertions.assertThatThrownBy(() -> sut.validate("//^&*\\1:12;123"));
    }

    @Test
    void 숫자부가_구분자로_시작하는_입력은_실패한다() {
        //given
        InputValidator sut = new InputValidator();

        //expected
        Assertions.assertThatThrownBy(() -> sut.validate("//^&*\\:1:12;123"));
    }

    @Test
    void 숫자부가_구분자로_종료하는_입력은_실패한다() {
        //given
        InputValidator sut = new InputValidator();

        //expected
        Assertions.assertThatThrownBy(() -> sut.validate("//^&*\\1:12;123:"));
    }

    @Test
    void 숫자부에_구분자가_연속해서_여러개_나오는_입력은_실패한다() {
        //given
        InputValidator sut = new InputValidator();

        //expected
        Assertions.assertThatThrownBy(() -> sut.validate("//^&*\\1:12:;123"));
    }


}