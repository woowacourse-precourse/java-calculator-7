package calculator.util;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사용자 입력 문자열에서 커스텀 구분자 및 계산식 추출 테스트")
class ExtractionUtilTest {

    @Test
    public void 단일_커스텀_구분자_추출_성공() {
        Map<String, char[]> inputsAndResults = new HashMap<>();
        inputsAndResults.put("//;\\n1,2,3", new char[]{';'});
        inputsAndResults.put("//!\\n1,2,3", new char[]{'!'});
        inputsAndResults.put("//\"\\n1,2,3", new char[]{'\"'});
        inputsAndResults.put("//'\\n1,2,3", new char[]{'\''});
        inputsAndResults.put("//$\\n1,2,3", new char[]{'$'});

        inputsAndResults.forEach((input, expected) -> {
            Assertions.assertArrayEquals(expected, ExtractionUtil.extractDelimiter(input));
        });
    }

    @Test
    public void 커스텀_구분자_설정_없을시_NULL_반환() {
        Map<String, char[]> inputsAndResults = new HashMap<>();
        inputsAndResults.put("1,2,3", new char[]{});
        inputsAndResults.put("/!\\n1,2,3", new char[]{});
        inputsAndResults.put("//\"1,2,3", new char[]{});
        inputsAndResults.put("1,2,3, ", new char[]{});
        inputsAndResults.put("//$", new char[]{});

        inputsAndResults.forEach((input, expected) -> {
            Assertions.assertArrayEquals(expected, ExtractionUtil.extractDelimiter(input));
        });
    }

    @Test
    public void 여러_커스텀_구분자_추출_성공() {
        Map<String, char[]> inputsAndResults = new HashMap<>();
        inputsAndResults.put("//;!\\n1,2,3", new char[]{';', '!'});
        inputsAndResults.put("//!+.\\n1,2,3", new char[]{'!', '+', '.'});
        inputsAndResults.put("//\"'|\\n1,2,3", new char[]{'\"', '\'', '|'});
        inputsAndResults.put("//'@#$\\n1,2,3", new char[]{'\'', '@', '#', '$'});
        inputsAndResults.put("//()_**\\n1,2,3", new char[]{'(', ')', '_', '*', '*'});

        inputsAndResults.forEach((input, expected) -> {
            Assertions.assertArrayEquals(expected, ExtractionUtil.extractDelimiter(input));
        });
    }

    @Test
    public void 커스텀_구분자_정의시_추출된_문자열_반환_성공() {
        Map<String, String> inputsAndResults = new HashMap<>();
        inputsAndResults.put("//;\\n1", "1");
        inputsAndResults.put("//!+.\\n1,2,3", "1,2,3");
        inputsAndResults.put("//\"'|\\n  1,2,3", "  1,2,3");
        inputsAndResults.put("//()_**\\n1,2,3 ", "1,2,3 ");
        inputsAndResults.put("//\\n1", "1");
        inputsAndResults.put("//!\\n1!2", "1!2");
        inputsAndResults.put("//:!\\n1:1!1", "1:1!1");
        inputsAndResults.put("//!\\n@\\n1!2@3", "1!2@3");
        inputsAndResults.put("//!\\n@\\n1!2\\n3", "1!2\\n3");
        inputsAndResults.put("//\\n1,2", "1,2");
        inputsAndResults.put("//\\n1,2\\n", "1,2\\n");
//        inputsAndResults.put("//\\n\\n\\n\\n1", "\\n\\n1");
        inputsAndResults.put("///\\n1/2", "1/2");
        // 숫자는 구분자가 될 수 없기 때문에 '\n'을 구분자로 설정하고 싶어도 사이에 숫자가 들어가면 무시된다.
        inputsAndResults.put("//'@#$\\n1,\\n2,3", "1,\\n2,3");
        inputsAndResults.put("//\\n2\\n121\\n1", "2\\n121\\n1");
        inputsAndResults.put("//;!\\n1,2,3\\n", "1,2,3\\n");

        inputsAndResults.forEach((input, expected) -> {
            Assertions.assertEquals(expected, ExtractionUtil.extractExpression(input));
        });
    }

    @Test
    public void 커스텀_구분자_미정의시_전체_문자열_반환_성공() {
        Map<String, String> inputsAndResults = new HashMap<>();
        inputsAndResults.put("1,2,3", "1,2,3");
        inputsAndResults.put("4:5:6", "4:5:6");
        inputsAndResults.put("1\\n2,3", "1\\n2,3");
        inputsAndResults.put("\\n1\\n2,3", "\\n1\\n2,3");
        inputsAndResults.put("/1\\n2,3", "/1\\n2,3");
        inputsAndResults.put("123\\n3", "123\\n3");

        inputsAndResults.forEach((input, expected) -> {
            Assertions.assertEquals(expected, ExtractionUtil.extractExpression(input));
        });
    }
}