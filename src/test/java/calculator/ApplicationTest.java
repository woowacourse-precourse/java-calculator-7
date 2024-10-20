package calculator;

import calculator.model.CalcModel;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private CalcModel calcModel;

    @BeforeEach
    void beforeEach() {
        calcModel = new CalcModel();
    }

    @Test
    void 빈_문자열_테스트() {
        Assertions.assertEquals(0, calcModel.calcResult(""));
    }

    @Test
    void 단일_숫자_테스트() {
        Assertions.assertEquals(3, calcModel.calcResult("3"));
    }

    @Test
    void 여러개_숫자_테스트() {
        Assertions.assertEquals(14, calcModel.calcResult("8:5,1"));
    }

    @Test
    void 커스텀_구분자_테스트() {
        Assertions.assertEquals(3, calcModel.calcResult("//;\n1;2"));
    }

    @Test
    void 커스텀_구분자_여러문자_테스트1() {
        Assertions.assertEquals(5, calcModel.calcResult("//*(\n1*(2*(2"));
    }

    @Test
    void 커스텀_구분자_여러문자_테스트2() {
        Assertions.assertEquals(7, calcModel.calcResult("//%%%\n2%%%4%%%1"));
    }

    @Test
    void 잘못된_커스텀_구분자_정의_예외_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calcModel.calcResult("//\n1*2*3"));
    }

    @Test
    void 정의되지_않은_구분자_예외_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calcModel.calcResult("//;;\n1,2,3"));
    }

    @Test
    void 숫자가_아닌_값_예외_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calcModel.calcResult("1,2:a"));
    }

    @Test
    void 음수_입력_예외_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calcModel.calcResult("-1,2,3"));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
