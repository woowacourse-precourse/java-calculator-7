package calculator;

import calculator.domain.Expression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionTest {
    @Test
    @DisplayName("올바른 형식의 커스텀 구분자를 추출한다.")
    void 올바른_형식의_커스텀_구분자_추출() {
        Expression expression = new Expression("//;\n1;2;3");
        assertThat(expression.getDelimiter()).isEqualTo(";");
    }

    @Test
    @DisplayName("커스텀 구분자가 없을 경우 기본 구분자로 설정한다.")
    void 기본_구분자로_설정() {
        Expression expression = new Expression("1,2:3");
        assertThat(expression.getDelimiter()).isEqualTo(",|:");
    }

    @Test
    @DisplayName("기본 구분자로 문자열을 분리한다.")
    void 기본_구분자로_문자열_분리() {
        Expression expression = new Expression("1,2:3");
        assertThat(expression.getTokens()).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자로 문자열을 분리한다.")
    void 커스텀_구분자로_문자열_분리() {
        Expression expression = new Expression("//;\n1;2;3");
        assertThat(expression.getTokens()).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("구분자 사이에 숫자가 없는 경우 예외를 발생시킨다.")
    void 구분자_사이에_숫자_없음_예외_발생() {
        assertThatThrownBy(() -> new Expression("1,,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자 사이에 숫자가 없습니다.");
    }

    @Test
    @DisplayName("문자열을 합산하여 결과를 반환한다.")
    void 문자열을_합산하여_결과_반환() {
        Expression expression = new Expression("1,2:3");
        int sum = expression.calculateSum();
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자가 두 글자 이상인 경우에도 추출한다.")
    void 커스텀_구분자_두_글자_이상_추출() {
        Expression expression = new Expression("//;;;\n1;;;2;;;3");
        assertThat(expression.getDelimiter()).isEqualTo(";;;");
    }

    @Test
    @DisplayName("커스텀 구분자가 특수문자인 경우에도 추출한다.")
    void 커스텀_구분자_특수문자_추출() {
        Expression expression = new Expression("//.\n1.2.3");
        assertThat(expression.getDelimiter()).isEqualTo(".");
    }

    @Test
    @DisplayName("비어있는 커스텀 구분자 사용 시 예외를 발생시킨다.")
    void 비어있는_커스텀_구분자_예외_발생() {
        assertThatThrownBy(() -> new Expression("//\n1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자가 비어 있습니다.");
    }
}
