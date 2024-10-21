package calculator.parser;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.Application;
import calculator.model.CalculatorModel;
import calculator.model.LongCalculatorModel;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BasicSeparatorParserTest extends NsTest {

    private Set<Character> separators;
    private final BasicSeparatorParser basicSeparatorParser;

    public BasicSeparatorParserTest() {
        basicSeparatorParser = new BasicSeparatorParser();
    }

    @BeforeEach
    public void initSeparators() {
        separators = basicSeparatorParser.getSeparators();
    }

    // 성공
    @Test
    @DisplayName("커스텀 구분자로 '/', ';'가 입력되는 테스트")
    public void hasSlashCustomSeparatorTest() {
        assertSimpleTest(() -> {
                    // given
                    String input = "///\\n//;\\n";
                    CalculatorModel model = new LongCalculatorModel(separators);
                    model.setSeparatorExpression(input);

                    // when
                    basicSeparatorParser.parse(model);

                    // then
                    assertThat(separators)
                            .contains('/')
                            .contains(';');
                }
        );
    }

    // 실패

    @Test
    @DisplayName("중복된 커스텀 구분자가 입력되는 테스트")
    public void hasDuplicationCustomSeparatorTest() {
        assertSimpleTest(() -> {
            // given
            String input = "//;\\n//;\\n";
            CalculatorModel model = new LongCalculatorModel(separators);
            model.setSeparatorExpression(input);

            // when
            assertThatThrownBy(() -> basicSeparatorParser.parse(model))

                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("'\\' 문자가 없는 값이 입력되는 테스트")
    public void hasNotBackslashTest() {
        assertSimpleTest(() -> {
            // given
            String input = "n";
            CalculatorModel model = new LongCalculatorModel(separators);
            model.setSeparatorExpression(input);

            //when
            assertThatThrownBy(() -> basicSeparatorParser.parse(model))

                    //then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("'//' 문자와 커스텀 구분자가 없는 값이 입력되는 테스트")
    public void hasNotSlashAndCustomSeparatorTest() {
        assertSimpleTest(() -> {
            // given
            String input = "\\n";
            CalculatorModel model = new LongCalculatorModel(separators);
            model.setSeparatorExpression(input);

            // when
            assertThatThrownBy(() -> basicSeparatorParser.parse(model))

                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("커스텀 구분자 형식의 가장 앞의 '//'가 존재하지 않는 입력이 들어오는 테스트")
    public void hasNotDoubleSlashIntoCustomSeparatorTest() {
        assertSimpleTest(() -> {
            // given
            String input = ";\\n";
            CalculatorModel model = new LongCalculatorModel(separators);
            model.setSeparatorExpression(input);

            // when
            assertThatThrownBy(() -> basicSeparatorParser.parse(model))

                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("커스텀 구분자 형식의 가장 앞의 '/'가 존재하지 않는 입력이 들어오는 테스트")
    public void hasNotFirstSlashIntoCustomSeparatorTest() {
        assertSimpleTest(() -> {
            // given
            String input = "/;\\n";
            CalculatorModel model = new LongCalculatorModel(separators);
            model.setSeparatorExpression(input);

            // when
            assertThatThrownBy(() -> basicSeparatorParser.parse(model))

                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("입력값의 가장 앞에 '\\n\\n'이 있는 입력이 들어오는 테스트")
    public void hasFirstDoubleLineBreakerTest() {
        assertSimpleTest(() -> {
            // given
            String input = "\\n\\n";
            CalculatorModel model = new LongCalculatorModel(separators);
            model.setSeparatorExpression(input);

            //when
            assertThatThrownBy(() -> basicSeparatorParser.parse(model))

                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("기본 구분자를 커스텀 구분자로 입력이 들어오는 테스트")
    public void hasDefaultSeparatorTest() {
        assertSimpleTest(() -> {
            // given
            String input = "//,\\n";
            CalculatorModel model = new LongCalculatorModel(separators);
            model.setSeparatorExpression(input);

            //when
            assertThatThrownBy(() -> basicSeparatorParser.parse(model))

                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
