package calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.model.Separator;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SeparatorServiceTest {
    SeparatorService separatorService = SeparatorService.getInstance();
    Separator separator = Separator.getInstance();

    @BeforeEach
    public void setUp() {
        separator.initiateSeparator();
    }

    @Test
    public void testFindSeparator() {
        String haveSeparator = "//;\\n//+\\n1;2;3";
        ArrayList<Character> expectedList = new ArrayList<>(Arrays.asList(',', ':', ';', '+'));

        String resultTest = separatorService.findSeparator(haveSeparator);

        assertEquals(resultTest, "1;2;3", "separatorService: 커스텀 부분자 이외의 타겟 문자열 추출 실패");
        assertEquals(separator.getSeparator(), expectedList, "separatorService: 커스텀 부분자 추가 실패");
    }
}
