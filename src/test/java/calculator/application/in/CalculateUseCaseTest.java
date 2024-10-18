package calculator.application.in;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.domain.CalculateExpression;
import org.junit.jupiter.api.Test;

class CalculateUseCaseTest {

    private final CalculateUseCase calculateUseCase;

    public CalculateUseCaseTest() {
        // Todo: CalculateUseCase 인터페이스의 구현체가 들어온다.
        this.calculateUseCase = null;
    }

    @Test
    void 쉼표_구분자를_사용할_수_있어요() {
        // Given
        CalculateExpression expression = CalculateExpression.fromString("1,2,3");

        // When
        Long res = calculateUseCase.calculate(expression);

        // Then
        assertThat(res)
                .isNotNull()
                .isInstanceOf(Long.class)
                .isEqualTo(6L);
    }

    @Test
    void 콜론_구분자를_사용할_수_있어요() {
        // Given
        CalculateExpression expression = CalculateExpression.fromString("1:2:3");

        // When
        Long res = calculateUseCase.calculate(expression);

        // Then
        assertThat(res)
                .isNotNull()
                .isInstanceOf(Long.class)
                .isEqualTo(6L);
    }

    @Test
    void 쉼표와_콜론_구분자를_같이_사용할_수_있어요() {
        // Given
        CalculateExpression expression = CalculateExpression.fromString("1,2:3");

        // When
        Long res = calculateUseCase.calculate(expression);

        // Then
        assertThat(res)
                .isNotNull()
                .isInstanceOf(Long.class)
                .isEqualTo(6L);
    }

    @Test
    void 커스텀_구분자를_사용할_수_있어요() {
        // Given
        CalculateExpression expression = CalculateExpression.fromString("//;\\n1,2;3");

        // When
        Long res = calculateUseCase.calculate(expression);

        // Then
        assertThat(res)
                .isNotNull()
                .isInstanceOf(Long.class)
                .isEqualTo(6L);
    }

    @Test
    void 잘못된_구분자를_사용하면_오류가_발생해요() {
        // Given
        CalculateExpression expression = CalculateExpression.fromString("1:2;3");

        // When
        // Then
        assertThatThrownBy(() -> calculateUseCase.calculate(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수를_사용하면_오류가_발생해요() {
        // Given
        CalculateExpression expression = CalculateExpression.fromString("-1:2:3");

        // When
        // Then
        assertThatThrownBy(() -> calculateUseCase.calculate(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }
}