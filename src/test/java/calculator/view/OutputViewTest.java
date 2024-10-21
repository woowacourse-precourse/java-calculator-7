package calculator.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private static final String RESULT = "9999999";
    OutputView outputView = new OutputView();

    @Test
    void 결과_출력() {
        outputView.showOutputMessage(RESULT);
    }

}