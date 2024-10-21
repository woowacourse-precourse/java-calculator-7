package calculator.controller;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.model.CustomDelimiter;
import calculator.model.DefaultDelimiter;
import calculator.model.Delimiter;
import calculator.model.InputData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

@DisplayName("구분자 작동 테스트")
class DelimiterControllerTest {
    private DelimiterController delimiterController;

    @BeforeEach
    void setUp() {
        delimiterController = new DelimiterController();
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(new InputData("//;\\n1;2;3"), CustomDelimiter.class, "커스텀 구분자 객체 생성"),
                Arguments.of(new InputData("1,2,3"), DefaultDelimiter.class, "기본 구분자 객체 생성"),
                Arguments.of(
                        new InputData("//\\n123"),
                        DefaultDelimiter.class,
                        "커스텀구분자에 아무것도 지정하지 않으면 기본 구분자 객체를 생성")
        );
    }

    @ParameterizedTest(name = "{2}")
    @MethodSource("inputData")
    @DisplayName("데이터 객체를 받아 구분자 객체를 생성한다")
    void createDelimiterInstance(InputData inputData, Class<? extends Delimiter> delimiterClass, String testCase) {
        assertThat(delimiterController.createDelimiterPart(inputData))
                .isInstanceOf(delimiterClass);
    }
}