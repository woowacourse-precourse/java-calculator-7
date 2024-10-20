package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class DelimiterCheckerTest {

    @Test
    void 기본구분자_분리_성공() {
        // given
        String target = "1,2:3";
        DelimiterChecker delimiterChecker = new DelimiterChecker(target, List.of(",", ":"));

        // when
        List<Integer> result = delimiterChecker.splitByDelimiter();

        // then
        assertEquals(List.of(1,2,3), result);
    }

    @Test
    void 숫자아닌문자_포함된_경우_실패() {
        // given
        String target = "1,2:3,a";
        DelimiterChecker delimiterChecker = new DelimiterChecker(target, List.of(",", ":"));

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            delimiterChecker.splitByDelimiter();
        });
    }

    @Test
    void 숫자가_정수범위를_넘어갈_경우_실패(){
        // given
        String target = "1,2:3,1000000000000000000000000000000";
        DelimiterChecker delimiterChecker = new DelimiterChecker(target, List.of(",", ":"));

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            delimiterChecker.splitByDelimiter();
        });

        // then
        assertEquals("정수로 변환할 수 있는 양수만 계산할 수 있습니다", exception.getMessage().split(":")[0]);
    }

    @Test
    void 구분자가_앞뒤로_있어도_성공(){
        // given
        String target = ",1,2:3,";
        DelimiterChecker delimiterChecker = new DelimiterChecker(target, List.of(",", ":"));

        // when
        List<Integer> result = delimiterChecker.splitByDelimiter();

        // then
        assertEquals(List.of(1,2,3), result);
    }

    @Test
    void 커스텀_구분자가_숫자여도_성공(){
        // given
        String target = "1213:4";
        DelimiterChecker delimiterChecker = new DelimiterChecker(target, List.of(",", ":","1"));

        // when
        List<Integer> result = delimiterChecker.splitByDelimiter();

        // then
        assertEquals(List.of(2,3,4), result);
    }

    @Test
    void 구분자가_연속될_경우_실패() {
        // given
        String target = "1,,2:3";
        DelimiterChecker delimiterChecker = new DelimiterChecker(target, List.of(",", ":"));

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            delimiterChecker.splitByDelimiter();
        });

        // then
        assertEquals("구분자 사이에는 1개 이상의 숫자를 넣어야합니다.", exception.getMessage());
    }

    @Test
    void 음수가_들어왔을_때_실패() {
        // given
        String target = "1,-2:3";
        DelimiterChecker delimiterChecker = new DelimiterChecker(target, List.of(",", ":"));

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            delimiterChecker.splitByDelimiter();
        });

        // then
        assertEquals("정수로 변환할 수 있는 양수만 계산할 수 있습니다", exception.getMessage().split(":")[0]);
    }

}