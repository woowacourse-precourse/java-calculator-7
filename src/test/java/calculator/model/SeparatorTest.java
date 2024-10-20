package calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SeparatorTest {
    Separator separator = Separator.getInstance();

    @BeforeEach
    public void setUp() {
        separator.initiateSeparator();
    }

    @Test
    public void testInitiateSeparator() {
        List<Character> expectedList = new ArrayList<>(Arrays.asList(',', ':'));

        assertEquals(expectedList, separator.getSeparator(), "separator: 구분자 리스트 초기화 오류");
    }

    @Test
    void testInsertSeparator() {
        separator.insertSeparator(';');
        separator.insertSeparator('+');

        List<Character> expectedList = new ArrayList<>(Arrays.asList(',', ':', ';', '+'));
        assertEquals(expectedList, separator.getSeparator(), "separator: 커스텀 구분자 추가 실패");
    }
}
