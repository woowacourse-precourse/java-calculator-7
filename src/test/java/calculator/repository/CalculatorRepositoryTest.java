package calculator.repository;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorRepositoryTest {

    private CalculatorRepository repository;

    @BeforeEach
    void setUp() {
        repository = new CalculatorRepository();
    }

    @Test
    void 기본_구분자_설정_성공_테스트() {
        // Given

        // When
        List<Character> expectedDelimiters = List.of(',', ':');

        // Then
        Assertions.assertThat(repository.getDelimiters()).containsAll(expectedDelimiters);
    }

    @Test
    void 커스텀_구분자_생성_성공_테스트() {
        // Given
        Character customDelimiter = ';';

        // When
        repository.createCustomDelimiter(customDelimiter);

        // Then
        Assertions.assertThat(repository.getDelimiters()).contains(customDelimiter);
    }
}
