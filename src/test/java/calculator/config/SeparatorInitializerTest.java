package calculator.config;

import static org.junit.jupiter.api.Assertions.*;

import calculator.repository.MemorySeparatorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SeparatorInitializerTest {
    private SeparatorInitializer separatorInitializer;
    private MemorySeparatorRepository separatorRepository;

    @BeforeEach
    void setUp() {
        separatorRepository = new MemorySeparatorRepository();
        separatorInitializer = new SeparatorInitializer(separatorRepository);
    }

    @DisplayName("기본 구분자 초기화 테스트")
    @Test
    void testInitialize() {
        separatorInitializer.initialize();

        assertTrue(separatorRepository.findAll()
                .stream()
                .anyMatch(i -> i
                        .value() == ':'));

        assertTrue(separatorRepository.findAll()
                .stream()
                .anyMatch(i -> i
                        .value() == ','));
    }
}