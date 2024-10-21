package calculator.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationControllerTest {

    @DisplayName("커스텀_구분자_숫자사용")
    @Test
    void checkUseCustomDelimiter() {
        assertSimpleTest(() -> {
            String input = "//7\\n7172";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            PrintStream originalOut = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            ApplicationController applicationController = new ApplicationController();

            assertEquals("덧셈할 문자열을 입력해 주세요.\n결과 : 3\n", outputStream.toString());

            System.setIn(System.in);
            System.setOut(originalOut);
        });
    }
    @DisplayName("커스텀_구분자_미사용")
    @Test
    void checkNotUseCustomDelimiter() {
        assertSimpleTest(() -> {
            String input = "1,2,3";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            PrintStream originalOut = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            ApplicationController applicationController = new ApplicationController();

            assertEquals("덧셈할 문자열을 입력해 주세요.\n결과 : 6\n", outputStream.toString());

            System.setIn(System.in);
            System.setOut(originalOut);
        });
    }
    @DisplayName("커스텀_구분자_미사용_소수계산")
    @Test
    void checkNotUseCustomDelimiter_Decimal() {
        assertSimpleTest(() -> {
            String input = "1.1,2.2,3.3";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            PrintStream originalOut = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            ApplicationController applicationController = new ApplicationController();

            assertEquals("덧셈할 문자열을 입력해 주세요.\n결과 : 6.6\n", outputStream.toString());

            System.setIn(System.in);
            System.setOut(originalOut);
        });
    }
    @DisplayName("커스텀_구분자_사용_소수계산")
    @Test
    void checkUseCustomDelimiter_Decimal() {
        assertSimpleTest(() -> {
            String input = "//;\\n1.1;2.1,3.1";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            PrintStream originalOut = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            ApplicationController applicationController = new ApplicationController();

            assertEquals("덧셈할 문자열을 입력해 주세요.\n결과 : 6.3\n", outputStream.toString());

            System.setIn(System.in);
            System.setOut(originalOut);
        });
    }
    @DisplayName("커스텀_구분자_숫자사용_소수계산")
    @Test
    void checkUseCustomDelimiterIsNumber_Decimal() {
        assertSimpleTest(() -> {
            String input = "//7\\n1.172.1,3.1";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            PrintStream originalOut = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            ApplicationController applicationController = new ApplicationController();

            assertEquals("덧셈할 문자열을 입력해 주세요.\n결과 : 6.3\n", outputStream.toString());

            System.setIn(System.in);
            System.setOut(originalOut);
        });
    }
    @DisplayName("커스텀_구분자_숫자사용_계산할숫자가없을경우")
    @Test
    void checkUseCustomDelimiterIsNumber_NotHaveNumber() {
        assertSimpleTest(() -> {
            String input = "//7\\n7777";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            PrintStream originalOut = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            ApplicationController applicationController = new ApplicationController();

            assertEquals("덧셈할 문자열을 입력해 주세요.\n결과 : 0\n", outputStream.toString());

            System.setIn(System.in);
            System.setOut(originalOut);
        });
    }

    @DisplayName("예외_테스트_소수사용_정수누락시")
    @Test
    void useDecimalNotHaveInteger_Error() {
        assertSimpleTest(() -> {
            String input = ".12,0.1";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            PrintStream originalOut = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            assertThatThrownBy(() -> new ApplicationController())
                    .isInstanceOf(IllegalArgumentException.class);

            System.setIn(System.in);
            System.setOut(originalOut);
        });
    }
    @DisplayName("예외_테스트_소수사용_소수누락시")
    @Test
    void useDecimalNotHaveFractional_Error() {
        assertSimpleTest(() -> {
            String input = "2.,0.1";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            PrintStream originalOut = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            assertThatThrownBy(() -> new ApplicationController())
                    .isInstanceOf(IllegalArgumentException.class);

            System.setIn(System.in);
            System.setOut(originalOut);
        });
    }
    @DisplayName("예외_테스트_커스텀구분자문자사용_숫자누락시")
    @Test
    void useCustomDelimiterNotHaveNumber_Error() {
        assertSimpleTest(() -> {
            String input = "//;\\;;;;;;";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            PrintStream originalOut = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            assertThatThrownBy(() -> new ApplicationController())
                    .isInstanceOf(IllegalArgumentException.class);

            System.setIn(System.in);
            System.setOut(originalOut);
        });
    }
    @DisplayName("예외_테스트_커스텀구분자미사용_숫자누락시")
    @Test
    void notUseCustomDelimiterNotHaveNumber_Error() {
        assertSimpleTest(() -> {
            String input = ",,,::,";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            PrintStream originalOut = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            assertThatThrownBy(() -> new ApplicationController())
                    .isInstanceOf(IllegalArgumentException.class);

            System.setIn(System.in);
            System.setOut(originalOut);
        });
    }
    @DisplayName("예외_테스트_커스텀구분자미사용_문자누락시")
    @Test
    void notUseCustomDelimiterNotHaveChar_Error() {
        assertSimpleTest(() -> {
            String input = "123123";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            PrintStream originalOut = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            assertThatThrownBy(() -> new ApplicationController())
                    .isInstanceOf(IllegalArgumentException.class);

            System.setIn(System.in);
            System.setOut(originalOut);
        });
    }
    @DisplayName("예외_테스트_숫자0만입력시")
    @Test
    void useZeroInteger_Error() {
        assertSimpleTest(() -> {
            String input = "0,1,2";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            PrintStream originalOut = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            assertThatThrownBy(() -> new ApplicationController())
                    .isInstanceOf(IllegalArgumentException.class);

            System.setIn(System.in);
            System.setOut(originalOut);
        });
    }
    @DisplayName("예외_테스트_소수0만입력시")
    @Test
    void useZeroDecimal_Error() {
        assertSimpleTest(() -> {
            String input = "0.0,1,2";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            PrintStream originalOut = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            assertThatThrownBy(() -> new ApplicationController())
                    .isInstanceOf(IllegalArgumentException.class);

            System.setIn(System.in);
            System.setOut(originalOut);
        });
    }
}
