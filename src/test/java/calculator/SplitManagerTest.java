package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SplitManagerTest {

    private final SplitManager splitManager = new SplitManager();

    @Test
    void 숫자로_시작X_실패() {
        assertThrows(IllegalArgumentException.class, () -> splitManager.splitString(new Input("a,2:3")));
    }

    @Test
    void 커스텀시작X_기본이외의_구분자_실패() {
        assertThrows(IllegalArgumentException.class, () -> splitManager.splitString(new Input("1+10,9")));
    }

    @Test
    void 중간공백_실패() {
        assertThrows(IllegalArgumentException.class, () -> splitManager.splitString(new Input("1, 10,9 :20")));
    }

    @Test
    void 아예_공백_성공_테스트() {
        String[] strings = splitManager.splitString(new Input(""));
        assertTrue(strings[0].isEmpty());
        assertEquals(1, strings.length);
    }

    @Test
    void 기본으로시작_split빈문자포함_성공() {
        String[] strings = splitManager.splitString(new Input(":1,4"));
        assertEquals("", strings[0]);
        assertEquals("1", strings[1]);
    }

    @Test
    void 커스텀구분자_이외의_구분자_실패() {
        assertThrows(IllegalArgumentException.class, () -> splitManager.splitString(new Input("//=\\n3=9+1=")));
    }

    @Test
    void 메타문자포함_성공() {
        Input input = new Input("//?\\n1?2?3:4");
        String[] strings = splitManager.splitString(input);
        assertArrayEquals(new String[]{"1", "2", "3", "4"}, strings);
    }

    @Test
    void 커스텀여러개_성공() {
        Input input = new Input("//?\\n//a\\n1?2?3a4");
        String[] strings = splitManager.splitString(input);
        assertArrayEquals(new String[]{"1", "2", "3", "4"}, strings);
    }

    @Test
    void 커스텀문자가_한번에_여러개_나눠진거_구분_커스텀아닌문자_실패() {
        Input input = new Input("//?a\\n//a\\n1?2?a3a4");
        // ?a랑 a인데 중간에 ?만 하나 있는 거 있음. 실패해야됨
        assertThrows(IllegalArgumentException.class, () -> splitManager.splitString(input));
    }

}
