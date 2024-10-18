package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionTest {
    @Test
    @DisplayName("올바른 형식의 커스텀 구분자를 사용한 합산 결과를 반환한다.")
    void 올바른_형식의_커스텀_구분자_사용() {
        // given
        Expression expression = new Expression("//;\\n1;2;3");

        // when
        int sum = expression.calculateSum();

        // then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자가 없을 경우 기본 구분자를 사용한 합산 결과를 반환한다.")
    void 기본_구분자로_합산() {
        // given
        Expression expression = new Expression("1,2:3");

        // when
        int sum = expression.calculateSum();

        // then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("기본 구분자와 커스텀 구분자가 모두 존재할 때 올바른 합산 결과를 반환한다.")
    void 기본_구분자와_커스텀_구분자_동시_사용() {
        // given
        Expression expression = new Expression("//;\\n1;2:3");

        // when
        int sum = expression.calculateSum();

        // then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("잘못된 구분자를 사용한 경우 예외를 발생시킨다.")
    void 잘못된_구분자_사용_예외_발생() {
        // when then
        assertThatThrownBy(() -> new Expression("1.2.3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 형식이 잘못되었습니다.");
    }


    @Test
    @DisplayName("잘못된 구분자로 문자열을 분리할 경우 예외를 발생시킨다.")
    void 잘못된_구분자로_문자열_분리_예외_발생() {
        assertThatThrownBy(() -> new Expression("1.2.3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 형식이 잘못되었습니다.");
    }


    @Test
    @DisplayName("구분자 사이에 숫자가 없는 경우 예외를 발생시킨다.")
    void 구분자_사이에_숫자_없음_예외_발생() {
        // when then
        assertThatThrownBy(() -> new Expression("1,,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 형식이 잘못되었습니다.");
    }

    @Test
    @DisplayName("커스텀 구분자가 두 글자 이상인 경우 예외를 발생시킨다.")
    void 커스텀_구분자_두_글자_이상_예외_발생() {
        // when then
        assertThatThrownBy(() -> new Expression("//!!\\n1!!2!!3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 한 글자여야 합니다.");
    }

    @Test
    @DisplayName("커스텀 구분자가 특수문자인 경우에도 올바른 합산 결과를 반환한다.")
    void 커스텀_구분자_특수문자_사용() {
        // given
        Expression expression = new Expression("//.\\n1.2.3");

        // when
        int sum = expression.calculateSum();

        // then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("비어있는 커스텀 구분자를 사용한 경우 예외를 발생시킨다.")
    void 비어있는_커스텀_구분자_예외_발생() {
        // when then
        assertThatThrownBy(() -> new Expression("//\\n1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 한 글자여야 합니다.");
    }
}
