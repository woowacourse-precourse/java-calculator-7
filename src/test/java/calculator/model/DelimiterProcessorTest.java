package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import calculator.view.InputView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterProcessorTest {

    DelimiterProcessor delimiterProcessor = new DelimiterProcessor();

    @Test
    @DisplayName("기본 구분자를 사용한 입력에서 구분자를 추출")
    void 기본_구분자_사용() {
        String userInput = "1:2,3";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        String result = delimiterProcessor.determineDelimiter(userInput);

        assertThat(result).contains(",", ":");
    }

    @Test
    @DisplayName("커스텀 구분자를 사용한 입력에서 구분자를 추출")
    void 커스텀_구분자_사용() {
        String userInput = "//^^\n1^^2^^3^^4";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        String result = delimiterProcessor.determineDelimiter(userInput);

        System.out.println("result = " + result);

        assertThat(result).contains("^^");
    }

    @Test
    @DisplayName("기본 구분자와 커스텀 구분자를 사용한 입력에서 구분자를 추출")
    void 기본_구분자_커스텀_구분자_사용() {
        String userInput = "//^^\n1,2:3^^4";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        String result = delimiterProcessor.determineDelimiter(userInput);

        System.out.println("result = " + result);

        assertThat(result).contains(",", ":", "^^");
    }


    @Test
    @DisplayName("커스텀 구분자를 여러번 사용한 입력에서 구분자를 추출")
    void 기본_구분자와_커스텀_구분자_사용() {
        String userInput = "//&\n//^^\n1&2&3^^4";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        String result = delimiterProcessor.determineDelimiter(userInput);

        System.out.println("result = " + result);

        assertThat(result).contains("^^", "&");
    }


}