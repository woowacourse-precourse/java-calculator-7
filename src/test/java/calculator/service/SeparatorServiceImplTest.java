package calculator.service;

import static org.junit.jupiter.api.Assertions.*;

import calculator.config.AppConfig;
import calculator.model.Separator;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SeparatorServiceImplTest {

    private final AppConfig appConfig = new AppConfig();
    private SeparatorService separatorService;

    @BeforeEach
    void setSeparatorService(){
        separatorService = appConfig.separatorService();
    }


    @DisplayName("구분자 저장")
    @Test
    void join() {
        Separator separator = new Separator('!');
        separatorService.join(separator);

        Set<Separator> allSeparator = separatorService.findAllSeparator();
        assertNotNull(allSeparator);
        assertTrue(allSeparator
                .stream()
                .anyMatch(i -> i
                        .value() == '!'));
    }

    @DisplayName("구분자 중복 저장")
    @Test
    void overlapJoin() {
        Separator separator1 = new Separator('!');
        Separator separator2 = new Separator('!');
        separatorService.join(separator1);
        separatorService.join(separator2);

        Set<Separator> allSeparator = separatorService.findAllSeparator();
        assertNotNull(allSeparator);
        assertTrue(allSeparator
                .stream()
                .anyMatch(i -> i
                        .value() == '!'));
        assertSame(3, allSeparator.size());
    }


    @DisplayName("한 글자가 아닌 구분자 저장 예외")
    @Test
    void extractLongCustomSeparator() {
        assertThrows(IllegalArgumentException.class, () ->
                separatorService.extractCustomSeparator(separatorService
                        .extractCustomSeparator("//!!\n123:123")));
    }

    @DisplayName("숫자인 구분자 저장 예외")
    @Test
    void extractNumericCustomSeparator() {
        assertThrows(IllegalArgumentException.class, () ->
                separatorService.extractCustomSeparator(separatorService
                        .extractCustomSeparator("//3\n123:123")));
    }
}