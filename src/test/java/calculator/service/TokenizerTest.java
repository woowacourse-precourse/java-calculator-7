package calculator.service;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TokenizerTest {

    @ParameterizedTest
    @MethodSource("provideLegalSource")
    void tokenizeTest(final String inputNumbers, final Numbers numbers) {
        final Tokenizer tokenizer = new Tokenizer(inputNumbers);
        tokenizer.addSeparator(new CharacterSequenceSeparator(","));
        tokenizer.addSeparator(new CharacterSequenceSeparator(":"));

        Assertions.assertThat(tokenizer.tokenize()).isEqualTo(numbers);
    }

    @ParameterizedTest
    @MethodSource("음수입력")
    void 음수(final String input) {
        final Tokenizer tokenizer = new Tokenizer(input);
        tokenizer.addSeparator(new CharacterSequenceSeparator(","));
        tokenizer.addSeparator(new CharacterSequenceSeparator(":"));
        Assertions.assertThatThrownBy(() -> tokenizer.tokenize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> 음수입력() {
        return Stream.of(
                Arguments.of("-102"),
                Arguments.of("102,,-103"),
                Arguments.of("-102")
        );
    }

    static Stream<Arguments> provideLegalSource() {
        return Stream.of(
                Arguments.of(
                        "1,2,3:4,5",
                        new Numbers(
                                List.of(
                                        new Number("1"),
                                        new Number("2"),
                                        new Number("3"),
                                        new Number("4"),
                                        new Number("5")
                                )
                        )
                ),
                Arguments.of(
                        "12,223,3232:422,511",
                        new Numbers(
                                List.of(
                                        new Number("12"),
                                        new Number("223"),
                                        new Number("3232"),
                                        new Number("422"),
                                        new Number("511")
                                )
                        )
                ),
                Arguments.of(
                        "",
                        new Numbers(
                                List.of(
                                        new Number("0")
                                )
                        )
                ),
                Arguments.of(
                        ",",
                        new Numbers(
                                List.of(
                                        new Number("0"),
                                        new Number("0")
                                )
                        )
                ),
                Arguments.of(
                        ",:",
                        new Numbers(
                                List.of(
                                        new Number("0"),
                                        new Number("0"),
                                        new Number("0")
                                )
                        )
                )
        );
    }
}