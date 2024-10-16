package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class InputTest {

    @Test
    void Input_커스텀이_아닌_문자열_숫자로_시작X_실패() {
        assertThrows(IllegalArgumentException.class, () -> new Input("a,2:3"));
    }

    @Test
    void Input_커스텀이_아닌데_기본이외의_구분자_실패() {
        assertThrows(IllegalArgumentException.class, () -> new Input("1+10,9"));
    }

    @Test
    void Input_커스텀이_아닌_문자열_중간공백_실패() {
        assertThrows(IllegalArgumentException.class, () -> new Input("1, 10,9 :20"));
    }

    @Test
    void Input_커스텀이_아닌_문자열_공백_성공_테스트() {
        assertEquals("", new Input("").getStr());
    }

    @Test
    void Input_커스텀이_아닌_문자열_기본구분자로_성공() {
        Input input = new Input("10:3,9");
        assertEquals("10:3,9", input.getStr());
    }

    @Test
    void Custom_개행문자로_끝나지_않아서_실패() {
        assertThrows(IllegalArgumentException.class, () -> new Input("//a2a"));
    }

    @Test
    void Custom_커스텀구분자_이외의_구분자_실패() {
        assertThrows(IllegalArgumentException.class, () -> new Input("//=\\n3=9+1="));
    }

    @Test
    void Custom_구분자_문자_제대로_받아_성공() {
        Input input = new Input("//-\\n23-1");
        assertEquals("-", input.getSplitter());
        assertEquals("23-1", input.getStr());
    }
}