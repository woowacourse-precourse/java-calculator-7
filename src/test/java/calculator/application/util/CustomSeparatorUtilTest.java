package calculator.application.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CustomSeparatorUtilTest {

    @ParameterizedTest(name = "({index}) : {arguments}")
    @ValueSource(strings = {
            "//,\\n1,2,3", "//;\\n1"
    })
    void 커스텀_구분자_입력_형식이_있을_경우_참(String text) {
        boolean result = CustomSeparatorUtil.hasCustomSeparator(text);

        assertThat(result).isTrue();
    }

    @ParameterizedTest(name = "({index}) : {arguments}")
    @ValueSource(strings = {
            "//1,2,3", "\\n1,2,3", "/,\\n1,2,3", "//,\n1,2,3"
    })
    void 커스텀_구분자_입력_형식이_없을_경우_거짓(String text) {
        boolean result = CustomSeparatorUtil.hasCustomSeparator(text);

        assertThat(result).isFalse();
    }

}
