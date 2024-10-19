package calculator.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import calculator.model.Separator;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SeparatorRepositoryTest {
    private MemorySeparatorRepository separatorRepository;

    @BeforeEach
    void setSeparatorRepository() {
        separatorRepository = new MemorySeparatorRepository();
    }

    @DisplayName("구분자 저장")
    @Test
    void testSaveSeparator() {
        Separator separator = new Separator('!');
        separatorRepository.save(separator);

        Set<Separator> allSeparator = separatorRepository.findAll();
        assertNotNull(allSeparator);
        assertTrue(allSeparator
                .stream()
                .anyMatch(i -> i
                        .value() == '!'));
    }
}
