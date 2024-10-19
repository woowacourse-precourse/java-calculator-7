package calculator.repository.separator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SeparatorRepositoryTest {

    private final SeparatorRepository separatorRepository;

    public SeparatorRepositoryTest() {
        this.separatorRepository = SeparatorRepositoryImpl.getInstance();
    }

    @BeforeEach
    void setUp() {
        separatorRepository.clearAll();
    }

    @Test
    void 구분자가_정상적으로_저장되는가() {
        String separator = "//d";
        List<Character> expected = List.of('d');

        separatorRepository.saveSeparator(separator);

        List<Character> separators = separatorRepository.getSeparators();

        Assertions.assertEquals(expected, separators);
    }

    /**
     * SeparatorsUtilsTest에서 이미 단위테스트 진행함
     * 통합적인 확인 용도
     */
    @Test
    void 구분자가_저장될때_올바르지_않은_형식이라면_오류가_발생() {
        String separator = "/s";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> separatorRepository.saveSeparator(separator));
    }
}

